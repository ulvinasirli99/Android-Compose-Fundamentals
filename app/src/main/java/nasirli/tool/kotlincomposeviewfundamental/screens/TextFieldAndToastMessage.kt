package nasirli.tool.kotlincomposeviewfundamental.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun TextFieldAndToastMessage() {

    var newSurnameValue by remember {
        mutableStateOf("")
    }

    var newPasswordValue by remember {
        mutableStateOf("")
    }

    var basicTextFieldValue by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    val keyboardController = LocalSoftwareKeyboardController.current

    val focusManager = LocalFocusManager.current


    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null, // Disables the click effect
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focusManager.clearFocus()
            },
        contentAlignment = Alignment.Center,
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
            TextField(
                value = newSurnameValue,
                onValueChange = {
                    newSurnameValue = it
                },
                label = {
                    Text(text = "Enter your Surname")
                },
                singleLine = true,
                placeholder = {
                    Text(text = "Ulvi Nasirov")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Enter your Surname", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Add, contentDescription = "")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                )
            )
            OutlinedTextField(
                value = newPasswordValue,
                onValueChange = {
                    newPasswordValue = it
                },
                label = {
                    Text(text = "Enter your Password")
                },
                singleLine = true,
                placeholder = {
                    Text(text = "Test1234")
                },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    IconButton(onClick = {/*TODO*/ }) {
                        Icon(imageVector = Icons.Outlined.Settings, contentDescription = "")
                    }
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Enter your password", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Check, contentDescription = "")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Go,
                ),
                keyboardActions = KeyboardActions(
                    onGo = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                )
            )
            TextField(
                value = basicTextFieldValue,
                onValueChange = { basicTextFieldValue = it },
                label = {
                    Text(text = "Your Name")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = null)
                },
                colors = TextFieldDefaults.colors(
                    unfocusedLabelColor = Color.Blue,
                    focusedLabelColor = Color.Cyan,
                    cursorColor = Color.Green,
                    unfocusedIndicatorColor = Color.Magenta,
                    unfocusedTrailingIconColor = Color.Black,
                    focusedIndicatorColor = Color.Green,
                ),
                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            )
        }
    }
}