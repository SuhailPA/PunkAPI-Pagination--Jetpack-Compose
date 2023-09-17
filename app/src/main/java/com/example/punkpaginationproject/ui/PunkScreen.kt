package com.example.punkpaginationproject.ui

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.punkpaginationproject.PunkViewModelProvider
import com.example.punkpaginationproject.data.local.PunkRoomDataItem

@Composable
fun PunkScreen(
    modifier: Modifier = Modifier,
    viewModel: PunkViewModel = viewModel(factory = PunkViewModelProvider.Factory)
) {
    val list = viewModel.pagerFlow.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(list.itemSnapshotList.items) {
            PunkItem(punkItem = it)
        }
    }
}

@Composable
fun PunkItem(punkItem: PunkRoomDataItem, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        modifier = Modifier.padding(5.dp), shape = CutCornerShape(
            topStart = 15.dp, bottomEnd = 15.dp
        )
    ) {
        Row(modifier = modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(
                    context = context
                )
                    .data(punkItem.imageUrl)
                    .build(),
                contentDescription = "Image",
                modifier = Modifier
                    .weight(1f)
                    .size(150.dp)
            )
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = punkItem.name,
                    style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = punkItem.tagline,
                    style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = punkItem.name,
                    style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(5.dp)
                )

            }
        }
    }

}