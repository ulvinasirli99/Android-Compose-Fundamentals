package nasirli.tool.kotlincomposeviewfundamental.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimatedTopBarWidget() {
    val scrollState = rememberScrollState()

    val scroll = false
    if (scrollState.value == 0) {
        // todo
    } else {
        // todo
    }
    var value = "the value is: " + scrollState.value


    val isScrolled by remember {
        derivedStateOf {
            scrollState.value == 0
        }
    }



    Log.i("ScrollStateValue:", "current: ${scrollState.value}, max: ${scrollState.maxValue}")

    Scaffold(Modifier.fillMaxSize(), topBar = {

        AnimatedVisibility(
            visible = isScrolled,
            exit = slideOutVertically() + fadeOut(),
            enter = slideInHorizontally()
        ) {
            TopAppBar(
                title = { Text(text = "Top App Bar") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Cyan)
            )
        }

    },
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {

                repeat(7) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                }
                repeat(7) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color.Yellow)
                    )
                }
            }
        }
    )
}