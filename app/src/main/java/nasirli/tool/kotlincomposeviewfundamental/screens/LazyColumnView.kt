package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import nasirli.tool.kotlincomposeviewfundamental.R

val namesOfPeople =
    arrayOf("Veronica", "Albert", "Casper", "Vitali", "Marta", "Jack", "Taylor", "Bella")
val agesOfPeople = arrayOf(23, 31, 43, 28, 37, 19, 21, 33)

@Composable
fun LazyColumnWidget(navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val modifier = Modifier
        val itemCount = namesOfPeople.size
        items(itemCount) { item ->
            ColumnItemA(
                itemIndex = item,
                title = namesOfPeople,
                ages = agesOfPeople,
                modifier,
                navController,
            )
        }
    }
}

@Composable
fun ColumnItemA(
    itemIndex: Int,
    title: Array<String>,
    ages: Array<Int>,
    modifier: Modifier,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(
                    route = "LazyColumnDetailWidget/$itemIndex"
                )
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cat_image),
                contentDescription = title[itemIndex],
                modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = title[itemIndex], fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text(text = ages[itemIndex].toString(), fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    itemIndex: Int,
    title: Array<String>,
    ages: Array<Int>,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.cat_image),
                contentDescription = title[itemIndex],
                modifier.clip(RoundedCornerShape(16.dp))
            )
        }
        Text(text = title[itemIndex], fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = ages[itemIndex].toString(), fontSize = 18.sp)
    }
}
