package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val languages = listOf(
    "Java",
    "Kotlin",
    "Flutter",
    "Dart",
    "Swift",
    "C#",
    "C++",
    "PHP",
    "Go",
    "R",
    "Javascript"
)

@Composable
@Preview
fun LazyRowWidget() {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(contentPadding = PaddingValues(10.dp)) {
            items(items = languages) { item ->
                RowItem(modifier = Modifier, name = item)
            }
        }
        LazyColumn() {
            items(items = languages) { item ->
                ColumnItem(modifier = Modifier, name = item)
            }
        }
    }
}

@Composable
fun RowItem(modifier: Modifier, name: String) {
    Card(
        modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(80.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ColumnItem(modifier: Modifier, name: String) {
    Card(
        modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
    }
}