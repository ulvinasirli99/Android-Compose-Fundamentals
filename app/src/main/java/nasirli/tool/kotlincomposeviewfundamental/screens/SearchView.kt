package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val list = listOf(
    "Java",
    "Kotlin",
    "Python",
    "Swift",
    "Java-script",
    "C",
    "C++",
    "XML",
    "Dart",
    "Go",
    "R",
    "PHP",
    "Ruby",
    "Perl",
    "SQL",
    "Objective-C",
    "HTML",
    "CSS"
)

@Composable
@Preview(showBackground = true)
fun SearchWidget() {
    val modifier: Modifier = Modifier
    Column(modifier.fillMaxSize()) {

        val textState = remember {
            mutableStateOf(TextFieldValue(""))
        }

        CustomSearchView(state = textState, placeHolder = "Search language", modifier = modifier)

        val searchedText = textState.value.text


        LazyColumn(modifier.padding(10.dp)) {
            items(items = list.filter {
                it.contains(searchedText, ignoreCase = true)
            }, key = { it }) { item ->
                CustomColumnItem(item = item)
            }
        }
    }
}

@Composable
fun CustomSearchView(
    state: MutableState<TextFieldValue>,
    placeHolder: String,
    modifier: Modifier,
) {
    TextField(
        value = state.value, onValueChange = { value ->
            state.value = value
        },
        modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(2.dp, Color.DarkGray, RoundedCornerShape(30.dp)),
        placeholder = {
            Text(text = placeHolder)
        },
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
        )
    )
}

@Composable
fun CustomColumnItem(item: String) {
    Column(Modifier.padding(10.dp)) {
        Text(text = item, modifier = Modifier.padding(10.dp), fontSize = 22.sp)
        HorizontalDivider()
    }
}
