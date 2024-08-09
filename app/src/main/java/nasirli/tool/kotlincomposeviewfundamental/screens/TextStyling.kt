package nasirli.tool.kotlincomposeviewfundamental.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nasirli.tool.kotlincomposeviewfundamental.R

@Composable
@Preview(showBackground = true)
fun TextStyling() {
//    val myFont = FontFamily(Font(R.font.arizonia))
//    Text(
//        stringResource(id = R.string.text_style_label).repeat(30),
//        modifier = Modifier.background(Color.Gray).width(400.dp),
//        color = Color.Blue,
//        fontSize = 25.sp,
//        fontStyle = FontStyle.Italic,
//        fontWeight = FontWeight.ExtraLight,
////        fontFamily = FontFamily.Monospace,
//        fontFamily = myFont,
//        letterSpacing = 15.sp,
////        textDecoration = TextDecoration.LineThrough,
//        textAlign = TextAlign.Center,
//        lineHeight = 40.sp,
//        maxLines = 3,
//        overflow = TextOverflow.Ellipsis,
//    )


    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent(firstLine = 20.sp))) {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 30.sp,
                )
            ) {
                append("J")
            }
            append("etpack")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 30.sp,
                )
            ) {
                append("C")
            }

            append("ompose")
        }

    })

}