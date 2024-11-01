package nasirli.tool.kotlincomposeviewfundamental.screens


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay

val sampleImages = listOf(
    "https://images.squarespace-cdn.com/content/v1/5e97431c825c59018588244f/1649110784714-BFUAEQ0KFS55CWVAD0I0/IMG_7721.jpg",
    "https://miro.medium.com/v2/resize:fit:1358/1*BiGs73GmPynlNEgXeUEMsw.png",
    "https://developer.android.com/static/develop/ui/compose/images/graphics-CSC-Portrait.png"
)


@Composable
fun ImageCarouselView(images: List<String>) {
    ComposableCarousal(images)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ComposableCarousal(
    carouselItems: List<String>,
    showDots: Boolean = true,
    delayMillis: Long = 3000L
) {
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(selectedItemIndex) {
        // Auto-change the image every 'delayMillis' milliseconds
        while (true) {
            delay(delayMillis)
            selectedItemIndex = (selectedItemIndex + 1) % carouselItems.size
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp), // Remove top and right padding, keep bottom padding
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageCarousel(
                    carouselItems = carouselItems,
                    selectedItemIndex = selectedItemIndex,
                    onSelectedItemChange = { index ->
                        selectedItemIndex = index
                    }
                )
                if (showDots) {
                    Spacer(modifier = Modifier.height(8.dp))
                    DotsIndicator(
                        numDots = carouselItems.size,
                        currentIndex = selectedItemIndex,
                        onDotClick = { index ->
                            selectedItemIndex = index
                        }
                    )
                }
            }
        }
    )
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ImageCarousel(
    carouselItems: List<String>,
    selectedItemIndex: Int,
    onSelectedItemChange: (Int) -> Unit
) {
    AnimatedVisibility(
        visible = selectedItemIndex >= 0, // To prevent animation on first item when recomposing
        enter = slideInHorizontally(
            initialOffsetX = { 1000 },
            animationSpec = tween(durationMillis = 1000)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { -1000 },
            animationSpec = tween(durationMillis = 1000)
        )
    ) {
        Crossfade(targetState = carouselItems[selectedItemIndex], label = "") { imageRes ->
            val painter: Painter = rememberAsyncImagePainter(imageRes)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth() // Take full width available
                    .height(320.dp) // Take full height available
                    .graphicsLayer {
                        // Add any transformation effects you desire
                    },
                contentScale = ContentScale.FillBounds, // Image takes full width and height of the Box
            )
        }
    }
}

@Composable
fun DotsIndicator(
    numDots: Int,
    currentIndex: Int,
    onDotClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until numDots) {
            Dot(index = i, isSelected = i == currentIndex, onDotClick)
            Spacer(modifier = Modifier.width(8.dp)) // Add space between dots
        }
    }
}

@Composable
fun Dot(
    index: Int,
    isSelected: Boolean,
    onDotClick: (Int) -> Unit
) {
    val color = if (isSelected) Color.LightGray else Color.Gray
    Box(
        modifier = Modifier
            .size(12.dp) // Increase the size of dots for better visibility
            .background(color = color, shape = CircleShape)
            .clickable {
                onDotClick(index)
            }
    )
}