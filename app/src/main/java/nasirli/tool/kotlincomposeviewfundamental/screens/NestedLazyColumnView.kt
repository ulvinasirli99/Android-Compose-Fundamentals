package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nasirli.tool.kotlincomposeviewfundamental.R


data class ChildDataClass(
    val image: Int
)


data class ParentDataClass(
    val title: String,
    val childList: List<ChildDataClass>
)

private val parentItemsList = ArrayList<ParentDataClass>()

@Composable
@Preview(showBackground = true)
fun NestedLazyColumnWidget() {
    val images = listOf(
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
        ChildDataClass(R.drawable.cat_image),
    )
    parentItemsList.add(ParentDataClass("Novel:", images))
    parentItemsList.add(ParentDataClass("Best Seller:", images.shuffled()))
    parentItemsList.add(ParentDataClass("History:", images.shuffled()))
    parentItemsList.add(ParentDataClass("Favorite:", images.reversed()))
    parentItemsList.add(ParentDataClass("Drama:", images.shuffled()))
    parentItemsList.add(ParentDataClass("Crime:", images))

    val modifier: Modifier = Modifier
    LazyColumn(contentPadding = PaddingValues(15.dp)) {
        items(parentItemsList.size) { it ->
            ColumnItemUI(
                modifier = modifier,
                parentItemsList = parentItemsList,
                itemIndex = it
            )
        }
    }
}


@Composable
fun ColumnItemUI(
    modifier: Modifier,
    parentItemsList: ArrayList<ParentDataClass>,
    itemIndex: Int
) {
    Card(
        modifier.padding(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {
        Text(
            text = parentItemsList[itemIndex].title,
            modifier.padding(12.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFC107)
        )
        LazyRow(contentPadding = PaddingValues(12.dp)) {
            items(parentItemsList[itemIndex].childList.size) { it ->
                RowItemUI(
                    modifier = modifier,
                    childList = parentItemsList[itemIndex].childList,
                    rowItemIndex = it
                )
            }
        }
    }
}

@Composable
fun RowItemUI(modifier: Modifier, childList: List<ChildDataClass>, rowItemIndex: Int) {
    Box(
        modifier
            .height(200.dp)
            .width(160.dp)
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xF1201E1F))
    ) {
        Image(
            painter = painterResource(id = childList[rowItemIndex].image),
            contentDescription = "",
            modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight,
        )
    }
}