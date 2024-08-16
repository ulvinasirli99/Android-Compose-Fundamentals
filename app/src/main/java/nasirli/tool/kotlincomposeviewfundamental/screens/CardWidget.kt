package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nasirli.tool.kotlincomposeviewfundamental.R

@Composable
@Preview
fun CardWidget() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(270.dp).shadow(spotColor = Color.Blue, elevation = 25.dp),
            //     shape = CutCornerShape(20.dp),
//            elevation = CardDefaults.cardElevation(15.dp),
            //  border = BorderStroke(3.dp, Color.Magenta),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.cat_image),
                    modifier = Modifier.align(Alignment.CenterHorizontally).offset(y = 10.dp),
                    contentDescription = null,
                )
                Text(
                    text = "Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp),
                )
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    fontWeight = FontWeight.W400,
                    fontSize = 13.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Blue,
                )
            }
        }
    }
}