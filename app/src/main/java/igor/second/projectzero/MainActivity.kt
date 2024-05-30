package igor.second.projectzero

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import igor.second.projectzero.activity.SettingMenu
import igor.second.projectzero.activity.ShoppingMenu
import igor.second.projectzero.activity.UserInfo
import igor.second.projectzero.activity.WorkAction
import igor.second.projectzero.activity.YourLikes
import igor.second.projectzero.ui.theme.ProjectZeroTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.attributes.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

        setContent {
            ProjectZeroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNavController(navController = rememberNavController())
                }
            }
        }
    }
}

sealed class Screens(val route: String){
    data object SettingMenu: Screens("SettingMenu")
    data object WorkAction: Screens("WorkAction")
    data object UserInfo: Screens("UserInfo")
    data object YourLikes: Screens("YourLikes")
    data object ShoppingMenu: Screens("ShoppingMenu")
}

@Composable
fun MyNavController(navController: NavHostController){
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row (modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton( onClick = { navController.navigate(Screens.SettingMenu.route) } ) {
                        Icon(
                            Icons.Outlined.MoreVert,
                            contentDescription = "Settings")
                    }
                    IconButton( onClick = { navController.navigate(Screens.ShoppingMenu.route) } ) {
                        Icon(
                            Icons.Outlined.ShoppingCart,
                            contentDescription = "ShoppingCard")
                    }
                    IconButton( onClick = { navController.navigate(Screens.WorkAction.route) } ) {
                        Icon(
                            Icons.Outlined.Star,
                            contentDescription = "Activity")
                    }
                    IconButton( onClick = { navController.navigate(Screens.YourLikes.route) } ) {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = "Like")
                    }
                    IconButton( onClick = { navController.navigate(Screens.UserInfo.route) } ) {
                        Icon(
                            Icons.Outlined.AccountCircle,
                            contentDescription = "UserInfo")
                    }
                }
            }
        }
    ) { innerPadding ->
        Box (modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Screens.WorkAction.route) {

                composable(route = Screens.WorkAction.route){
                    WorkAction(navController)
                }
                composable(route = Screens.UserInfo.route){
                    UserInfo(navController)
                }
                composable(route = Screens.ShoppingMenu.route){
                    ShoppingMenu(navController)
                }
                composable(route = Screens.YourLikes.route){
                    YourLikes(navController)
                }
                composable(route = Screens.SettingMenu.route){
                    SettingMenu(navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectZeroTheme {
        MyNavController(navController = rememberNavController())
    }
}