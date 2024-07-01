package shakti.thread.application.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import shakti.thread.application.screens.*

@Composable
fun NavGraph(navHostController: NavHostController){
   NavHost(navController = navHostController, startDestination = Routes.spalsh.routes){
        composable(Routes.spalsh.routes){
            Splash(navHostController)
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

       composable(Routes.login.routes){
           Login(navHostController)
       }

       composable(Routes.register.routes){
           Register(navHostController)
       }

       composable(Routes.bottomNav.routes){
           BottomNav(navHostController)
       }
   }
}