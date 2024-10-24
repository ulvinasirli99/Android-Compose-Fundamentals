package nasirli.tool.kotlincomposeviewfundamental.screens

import android.transition.Slide
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.SimpleExoPlayer
import kotlinx.coroutines.delay


@OptIn(UnstableApi::class)
@Composable
fun ExoPlayerView(
    modifier: Modifier = Modifier,
    audioUrl: String
) {
    val context = LocalContext.current

    val exoPlayer = remember {
        SimpleExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(audioUrl)
            setMediaItem(mediaItem)
            prepare()
        }
    }

    var isPlaying by remember {
        mutableStateOf(false)
    }

    var currentPosition by remember {
        mutableLongStateOf(0)
    }

    var duration by remember {
        mutableLongStateOf(0)
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = exoPlayer) {
        val listener = object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                isLoading = playbackState == Player.STATE_BUFFERING
            }
        }

        exoPlayer.addListener(listener)

    }

    LaunchedEffect(key1 = exoPlayer) {
        while (true) {
            currentPosition = exoPlayer.currentPosition
            duration = exoPlayer.duration
            delay(10L)
        }
    }

    DisposableEffect(key1 = exoPlayer) {
        onDispose {
            exoPlayer.release()
        }
    }

    fun seekToPosition(newPosition: Float) {
        val seekPosition = (newPosition * duration).toLong()
        exoPlayer.seekTo(seekPosition)
    }

    LaunchedEffect(isPlaying) {
        exoPlayer.playWhenReady = isPlaying
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            if (isLoading) {
                CircularProgressIndicator()
                Spacer(modifier = modifier.height(20.dp))
            }
                Text(
                    text = if (isPlaying) "Playing Audio" else "Paused",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(onClick = { isPlaying = !isPlaying }) {
                        Text(text = if (isPlaying) "Pause" else "Play")
                    }
                }
                if (duration > 0L) {
                    Slider(
                        value = currentPosition.toFloat() / duration.toFloat(),
                        onValueChange = { seekToPosition(it) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.primary,
                            activeTrackColor = MaterialTheme.colorScheme.primary,
                        )
                    )

                    // Display current position and total duration
                    Text(
                        text = "${formatTime(currentPosition)} / ${formatTime(duration)}",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }

        }

    }

    // Helper function to format milliseconds into minutes and seconds
    fun formatTime(milliseconds: Long): String {
        val minutes = (milliseconds / 1000) / 60
        val seconds = (milliseconds / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    @Composable
    @Preview(showBackground = true)
    fun AudioPlayerScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ExoPlayerView(
                modifier = Modifier.fillMaxWidth(),
                audioUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3"
            )
        }
    }