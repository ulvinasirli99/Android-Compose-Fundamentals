package nasirli.tool.kotlincomposeviewfundamental

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.os.LocaleListCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import nasirli.tool.kotlincomposeviewfundamental.screens.movie_app.navigation.MovieNavigation
import nasirli.tool.kotlincomposeviewfundamental.screens.multilanguage.MultiLanguageApp
import nasirli.tool.kotlincomposeviewfundamental.screens.viewmodel.MovieViewModel
import nasirli.tool.kotlincomposeviewfundamental.ui.theme.KotlinComposeViewFundamentalTheme
import org.intellij.lang.annotations.Language

class MainActivity : ComponentActivity() {
//    private val db by lazy {
//        Room.databaseBuilder(
//            applicationContext,
//            NoteDatabase::class.java,
//            name = "note.db"
//        ).build()
//    }
//    private val viewModel by viewModels<NoteViewModel>(
//        factoryProducer = {
//            object : ViewModelProvider.Factory {
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    return NoteViewModel(NoteRepository(db)) as T
//                }
//            }
//        }
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            KotlinComposeViewFundamentalTheme {

                WindowCompat.setDecorFitsSystemWindows(window, false)

                window.setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )

                MultiLanguageApp()


//                val linearGradientBrush = Brush.linearGradient(
//                    colors = listOf(
//                        Color(0xFFB226E1),
//                        Color(0xFFFC6603),
//                        Color(0xFF5995EE),
//                        Color(0xFF3D3535)
//                    ),
//                    start = Offset(Float.POSITIVE_INFINITY, 0f),
//                    end = Offset(0f, Float.POSITIVE_INFINITY),
//                )
//
//
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//
//                    val movieViewModel = viewModel<MovieViewModel>()
//                    val state = movieViewModel.state
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(linearGradientBrush)
//                    ) {
//                        MovieNavigation()
//                    }
//
//                }


//                RoomDatabaseView(viewModel, this)
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    WebViewWidget(Modifier.padding(innerPadding))
//                }
//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "LazyColumnWidget") {
//                    composable(route = "LazyColumnWidget") {
//                        LazyColumnWidget(navController)
//                    }
//                    composable(route = "LazyColumnDetailWidget/{index}", arguments = listOf(
//                        navArgument(name = "index"){
//                            type = NavType.IntType
//                        }
//                    )) { index ->
//                        DetailScreen(
//                            itemIndex = index.arguments?.getInt("index") ?: 0,
//                            title = namesOfPeople,
//                            ages = agesOfPeople,
//                            modifier = Modifier,
//                        )
//                    }
//                }
            }
        }
    }

}