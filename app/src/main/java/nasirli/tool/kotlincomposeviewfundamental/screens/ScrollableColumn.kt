package nasirli.tool.kotlincomposeviewfundamental.screens

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun ScrollableColumn() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scrollState = rememberScrollState()

//        val scrolled by remember {
//            derivedStateOf {
//                scrollState.value != 0
//            }
//        }

        Log.i("ScrollStateValue:", "current: ${scrollState.value}, max: ${scrollState.maxValue}")

        MainUi(scrollState = scrollState)

    }
}

@Composable
fun MainUi(scrollState: ScrollState) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // This section is responsible for scrolling of Column ....
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xffffc107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "1", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xffff8107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "2", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(145.dp)
                .background(Color(0xffffc107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "3", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xffff8107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "4", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color(0xffffc107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "5", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color(0xffff8107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "6", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xffffc107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "7", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .background(Color(0xffff8107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "8", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xffffc107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "9", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(105.dp)
                .background(Color(0xffff8107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "10", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xffffc107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "11", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)
                .background(Color(0xffff8107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "12", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(155.dp)
                .background(Color(0xffffc107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "13", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xffff8107)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "14", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }
    }
}