package nasirli.tool.kotlincomposeviewfundamental.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel


@Composable
fun ComposeViewModel(countViewModel: CountViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val viewModel = countViewModel
        var count by remember {
            mutableStateOf(0)
        }
        count = viewModel.number
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Count: $count", fontSize = 36.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.incCount()
                count = viewModel.number
                //count ++
            }) {
                Text(text = "Button", fontSize = 36.sp)
            }

        }

    }
}


class CountViewModel : ViewModel() {

    var number = 0
    fun incCount() {
        number++
    }
}