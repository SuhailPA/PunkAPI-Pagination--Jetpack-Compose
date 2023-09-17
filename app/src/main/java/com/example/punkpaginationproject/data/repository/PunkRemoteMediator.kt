package com.example.punkpaginationproject.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.punkpaginationproject.data.local.PunkDatabase
import com.example.punkpaginationproject.data.local.PunkRoomDataItem
import com.example.punkpaginationproject.data.remote.PunkAPI
import com.example.punkpaginationproject.data.remote.toPunkRoomDataItem
import okio.IOException
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class PunkRemoteMediator(
    val roomDb: PunkDatabase,
    val punkAPI: PunkAPI
) : RemoteMediator<Int, PunkRoomDataItem>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PunkRoomDataItem>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> {
                    1
                }

                LoadType.PREPEND -> {
                    return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                }

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        val page =  (lastItem.id / state.config.pageSize) + 1
                        page
                    }
                }
            }

            val beersData = punkAPI.getAllBears(
                page = loadKey,
                per_page = state.config.pageSize
            )

            if (loadType == LoadType.REFRESH) {
                roomDb.punkDao().clearDB()
            }

            val punkItem = beersData.map { it.toPunkRoomDataItem() }
            roomDb.punkDao().insertPunkItems(list = punkItem)

            return MediatorResult.Success(endOfPaginationReached = beersData.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}