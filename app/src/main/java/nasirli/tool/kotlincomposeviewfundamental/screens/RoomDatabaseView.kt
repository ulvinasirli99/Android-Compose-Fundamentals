package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import nasirli.tool.kotlincomposeviewfundamental.screens.roomDB.Note
import nasirli.tool.kotlincomposeviewfundamental.screens.viewmodel.NoteViewModel


@Composable
fun RoomDatabaseView(
    viewModel: NoteViewModel, componentActivity: ComponentActivity
) {

    val focusManager = LocalFocusManager.current

    var name by remember {
        mutableStateOf("")
    }

    var body by remember {
        mutableStateOf("")
    }

    val note = Note(name, body)

    var noteList by remember {
        mutableStateOf(listOf<Note>())
    }

    viewModel.getNotes().observe(componentActivity) {
        noteList = it
    }

    Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {

        Button(onClick = {
            viewModel.upsertNote(note)
            // To Reset TextField
            name = ""
            body = ""
            // Close Fields Focus Node
            focusManager.clearFocus()
        }) {
            Text(text = "set data")
        }

        TextField(value = name, onValueChange = {
            name = it
        }, placeholder = {
            Text(text = "name")
        })

        TextField(value = body, onValueChange = {
            body = it
        }, placeholder = {
            Text(text = "body")
        })

        LazyColumn {
            itemsIndexed(items = noteList, key = { _, noteItem ->
                noteItem.hashCode()
            }) { _, note ->


                val deleteState = rememberSwipeToDismissBoxState(confirmValueChange = {
                    viewModel.deleteNote(note)
                    true
                })

                SwipeToDismissBox(state = deleteState, backgroundContent = {

                    val color = when (deleteState.dismissDirection) {

                        SwipeToDismissBoxValue.EndToStart -> Color.Red

                        SwipeToDismissBoxValue.StartToEnd -> Color.Green

                        SwipeToDismissBoxValue.Settled -> Color.Transparent

                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = 20.dp, vertical = 6.dp)
                    )
                }, content = {
                    Column(Modifier.padding(10.dp)) {
                        Text(text = "Name : ${note.noteName}")
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = "Body : ${note.noteBody}")
                        HorizontalDivider(
                            Modifier
                                .fillMaxWidth()
                                .padding(6.dp)
                        )
                    }
                })
            }
        }
    }
}
