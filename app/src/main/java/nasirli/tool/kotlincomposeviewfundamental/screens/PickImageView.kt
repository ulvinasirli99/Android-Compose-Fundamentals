package nasirli.tool.kotlincomposeviewfundamental.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
@Preview
fun PickImageWidget() {

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var selectedImageUriList by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }

    val singleImagePickLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            selectedImageUri = uri
        })

    val multipleImagePickLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uri ->
            selectedImageUriList = uri
        })

    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {

            Button(onClick = {
                singleImagePickLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }) {
                Text(text = "pick single image")
            }

            Button(onClick = {
                multipleImagePickLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }) {
                Text(text = "pick multiple image")
            }

        }
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            item {
                AsyncImage(
                    model = selectedImageUri,
                    contentDescription = "",
                    Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                HorizontalDivider(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            items(selectedImageUriList) { uri ->
                AsyncImage(
                    model = uri,
                    contentDescription = "",
                    Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                HorizontalDivider(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

            }
        }
    }
}