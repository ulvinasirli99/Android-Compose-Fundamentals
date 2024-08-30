package nasirli.tool.kotlincomposeviewfundamental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nasirli.tool.kotlincomposeviewfundamental.screens.BottomAppBarWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.BottomNavigationWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.DetailScreen
import nasirli.tool.kotlincomposeviewfundamental.screens.ExpandableFloatingActionWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.LazyColumnWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.LottieAnimationWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.NestedLazyColumnWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.PickImageWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.SearchWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.SwipeWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.TopAppBarWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.WebViewWidget
import nasirli.tool.kotlincomposeviewfundamental.screens.agesOfPeople
import nasirli.tool.kotlincomposeviewfundamental.screens.namesOfPeople
import nasirli.tool.kotlincomposeviewfundamental.ui.theme.KotlinComposeViewFundamentalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeViewFundamentalTheme {
                PickImageWidget()
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