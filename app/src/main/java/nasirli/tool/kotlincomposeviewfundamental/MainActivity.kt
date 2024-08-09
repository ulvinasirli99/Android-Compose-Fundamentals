package nasirli.tool.kotlincomposeviewfundamental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nasirli.tool.kotlincomposeviewfundamental.screens.SurfaceView
import nasirli.tool.kotlincomposeviewfundamental.ui.theme.KotlinComposeViewFundamentalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeViewFundamentalTheme {
                SurfaceView()
            }
        }
    }
}