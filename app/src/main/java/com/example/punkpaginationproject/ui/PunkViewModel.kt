package com.example.punkpaginationproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.example.punkpaginationproject.data.local.PunkRoomDataItem

class PunkViewModel(pager: Pager<Int, PunkRoomDataItem>) : ViewModel() {
    val pagerFlow = pager.flow.cachedIn(
        viewModelScope
    )
}