package nasirli.tool.kotlincomposeviewfundamental.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun BottomAppBarWidget() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                Modifier
                    .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 30.dp)),
                containerColor = Color(0xffff9800)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
                    }
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp,
                            bottomStart = 30.dp
                        ),
                        containerColor = Color(0xffffeb3b)
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "add")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
                    }
                }
            }
        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp),
//                containerColor = Color(0xffffeb3b)
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
//            }
//        }
    ) {

    }
}