package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nasirli.tool.kotlincomposeviewfundamental.R

@Composable
@Preview
fun ImageWidget() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat_image),
            contentDescription = "Picture",
            Modifier
                .size(200.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(2.dp, Color.Red, shape = RoundedCornerShape(12.dp)),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillBounds,
            alpha = 0.5f
        )

        Image(
            painter = painterResource(id = R.drawable.cat_image),
            contentDescription = "Picture",
            Modifier
//                .size(200.dp)
                .padding(10.dp)
                .clip(CutCornerShape(16.dp))
                .border(2.dp, Color.Red, shape = CutCornerShape(12.dp)),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth,
//            alpha = 0.5f
        )

        Image(
            painter = painterResource(id = R.drawable.cat_image),
            contentDescription = "Picture",
            Modifier
                .size(200.dp)
                .padding(10.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Red, shape = CircleShape),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop,
//            alpha = 0.5f
        )
    }
}