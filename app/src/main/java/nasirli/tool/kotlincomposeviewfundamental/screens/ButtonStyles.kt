package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun ButtonStyles() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 60.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp)
        ) {
            Text(text = "Rounded corner button")
        }

        Button(
            onClick = { /*TODO*/ },
            shape = CutCornerShape(8.dp)
        ) {
            Text(text = "Cut corner button")
        }

        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            modifier = Modifier.size(100.dp)
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 6.dp,
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfffedbd0),
                contentColor = Color.DarkGray,
            ),
            border = BorderStroke(1.dp,Color.Magenta)
        ) {
            Text(text = "Rounded corner button")
            Icon(imageVector = Icons.Filled.Face, contentDescription = null)
        }
    }
}