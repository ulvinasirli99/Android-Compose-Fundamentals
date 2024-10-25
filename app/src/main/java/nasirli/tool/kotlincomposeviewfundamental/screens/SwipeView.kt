package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun SwipeWidget() {

    val list = remember {
        mutableStateListOf(
            "Friend",
            "Computer",
            "Poster",
            "Lima",
            "Problem",
        )
    }

    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(items = list, key = { _, listItem ->
            listItem.hashCode()
        }) { index, item ->
            val state = rememberSwipeToDismissBoxState(
                confirmValueChange = {
//                    if (it == SwipeToDismissBoxValue.EndToStart) {
//                        list.remove(item)
//                    }
                    list.remove(item)
                    true
                }
            )
            SwipeToDismissBox(state = state, backgroundContent = {
                val color = when (state.dismissDirection) {
                    SwipeToDismissBoxValue.EndToStart -> Color.Red

                    SwipeToDismissBoxValue.StartToEnd -> Color.Green

                    SwipeToDismissBoxValue.Settled -> Color.Transparent
                }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color)
                    .padding(horizontal = 20.dp, vertical = 6.dp)) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }
            }, content = {
                ItemUI(list = list, itemIndex = index)
            })
        }
    }

}

@Composable
fun ItemUI(modifier: Modifier = Modifier, list: List<String>, itemIndex: Int) {
    Card(modifier.padding(horizontal = 20.dp, vertical = 6.dp)) {
        Box(
            modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = list[itemIndex], fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }
    }
}
