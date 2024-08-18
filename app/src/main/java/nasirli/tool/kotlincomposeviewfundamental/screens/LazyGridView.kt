package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
@Preview
fun LazyGridWidget() {
    val modifier: Modifier = Modifier
    LazyVerticalGrid(
        columns = GridCells.Adaptive(125.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(100) { item ->
            MyCard(
                item,
                modifier,
            )
        }
    }
}

@Composable
fun MyCard(item: Int, modifier: Modifier) {
    Card(
        modifier
            .size(100.dp)
            .padding(6.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        ),
    ) {
        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = item.toString(), fontSize = 22.sp)
        }
    }
}
