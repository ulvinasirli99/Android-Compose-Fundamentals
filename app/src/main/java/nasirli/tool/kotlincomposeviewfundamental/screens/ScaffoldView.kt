package nasirli.tool.kotlincomposeviewfundamental.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun ScaffoldWidget() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top Bar")
                },
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(text = "Bottom Bar")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }
    ) {
      contentPadding ->
        Column(Modifier.padding(contentPadding)) {
            Text(text = "Content")
        }
    }
}