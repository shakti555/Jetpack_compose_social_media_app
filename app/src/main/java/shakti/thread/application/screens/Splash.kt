package shakti.thread.application.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import shakti.thread.application.R
import shakti.thread.application.navigation.Routes

@Composable
fun Splash(navHostController : NavHostController){

   ConstraintLayout(modifier = Modifier.fillMaxSize()) {
          val (image) = createRefs()
         Image(painter = painterResource(id = R.drawable.splash_icon), contentDescription = "app logo",
         modifier = Modifier.constrainAs(image){
             top.linkTo(parent.top)
             bottom.linkTo(parent.bottom)
             start.linkTo(parent.start)
             end.linkTo(parent.end)
         })
   }

    LaunchedEffect(key1 = true ){
        delay(3000)
        navHostController.navigate(Routes.login.routes){
            popUpTo(navHostController.graph.startDestinationId)
            launchSingleTop = true
        }
    }
}