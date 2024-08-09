package nasirli.tool.kotlincomposeviewfundamental.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun StateAndReComposition() {
//    val count = remember {
//        mutableIntStateOf(0)
//    }

    var count by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = {
            count++
            Log.d("Count : ", "$count")
//            count.intValue++
//            Log.d("Count : ", "${count.intValue}")
        }) {
//        Text(text = "Count = ${count.intValue}")
            Text(text = "Count = $count")
        }
        Spacer(modifier = Modifier.size(25.dp))
//        Text(text = "Count = ${count.intValue}")
        Text(text = "Count = $count")

    }
}