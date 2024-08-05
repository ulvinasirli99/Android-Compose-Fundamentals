package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun RowAndColumnWidget() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(text = "Text One", fontSize = 18.sp)
        Text(text = "Text Two", fontSize = 18.sp)
        Text(text = "Text Third", fontSize = 18.sp)
    }
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = "Text One", fontSize = 18.sp)
        Text(text = "Text Two", fontSize = 18.sp)
        Text(text = "Text Third", fontSize = 18.sp)
    }
}