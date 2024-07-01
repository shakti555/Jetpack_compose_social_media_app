package shakti.thread.application.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import shakti.thread.application.model.BottomNavItem
import shakti.thread.application.navigation.Routes
import java.lang.reflect.Modifier

@Composable
fun BottomNav(navHostController: NavHostController){

    val navHostController1  = rememberNavController()

    Scaffold(bottomBar =  {MyBottomBar(navHostController1)}) {it ->
        NavHost(navController = navHostController1, startDestination = Routes.home.routes,
        modifier = androidx.compose.ui.Modifier.padding(it)){
            composable(Routes.spalsh.routes){
                Splash(navHostController1)
            }

            composable(Routes.home.routes){
                Home()
            }

            composable(Routes.addThread.routes){
                AddThreads()
            }

            composable(Routes.profile.routes){
                Profile()
            }

            composable(Routes.search.routes){
                Search()
            }

            composable(Routes.notification.routes){
                Notification()
            }
        }
        
    }
}


@Composable
fun MyBottomBar(navHostController: NavHostController){

    val backStackEntry = navHostController.currentBackStackEntryAsState()

    val list = listOf(BottomNavItem(
        "Home",
        Routes.home.routes
    ,Icons.Rounded.Home
    ),

        BottomNavItem(
            "Add Thread",
            Routes.addThread.routes
            ,Icons.Rounded.Add
        ),

        BottomNavItem(
            "Profile",
            Routes.profile.routes
            ,Icons.Rounded.Person
        ),

        BottomNavItem(
            "Search",
            Routes.search.routes
            ,Icons.Rounded.Search
        )
    )

    BottomAppBar {

        list.forEach {
            val selected = it.route == backStackEntry?.value?.destination?.route
            NavigationRailItem(selected = selected, onClick = {
                navHostController.navigate(it.route){
                    popUpTo(navHostController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }, icon = {
               androidx.compose.material.Icon(imageVector = it.icon, contentDescription = "")
            })

        }
    }

}