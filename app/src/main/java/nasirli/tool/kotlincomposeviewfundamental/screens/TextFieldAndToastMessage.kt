package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun TextFieldAndToastMessage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        var newTextValue by remember {
            mutableStateOf("")
        }
        Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
            TextField(
                value = newTextValue,
                onValueChange = {
                    newTextValue = it
                },
                label = {
                    Text(text = "Enter your Surname")
                }
            )
        }
    }
}