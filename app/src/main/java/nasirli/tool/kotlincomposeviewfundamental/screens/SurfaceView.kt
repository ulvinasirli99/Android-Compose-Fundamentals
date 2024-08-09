package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview(showBackground = true)
fun SurfaceView() {
    Surface(
        modifier = Modifier
            .height(220.dp)
            .width(220.dp)
            .padding(16.dp),
        color = Color.Cyan,
        contentColor = Color.Black,
        shadowElevation = 30.dp,
//        shape = RoundedCornerShape(12.dp)
        shape = CutCornerShape(100.dp),
        border = BorderStroke(4.dp, color = Color.Red)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Text to show Surface View")
        }
    }
}