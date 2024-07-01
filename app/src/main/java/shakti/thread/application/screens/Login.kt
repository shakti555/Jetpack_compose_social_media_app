package shakti.thread.application.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import shakti.thread.application.R
import shakti.thread.application.navigation.Routes


@Composable
fun Login(navHostController: NavHostController){
   var email by remember { mutableStateOf("") }
   var password by remember { mutableStateOf("") }


   Column(modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center) {

       Image(
           painter = painterResource(id = R.drawable.loginlogo),
           contentDescription = "My Image",
           modifier = Modifier.height(100.dp).width(100.dp)
       )

      OutlinedTextField(
         value = email,
         onValueChange = { email = it },
         label = { Text("Email") },
         keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
         ),
         singleLine = true,
         modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
      )

      OutlinedTextField(value = password,
         onValueChange = {password = it},
         label = { Text("Password")},
         keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
         ),
         singleLine = true,
         modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
      )

      Button(onClick = {  }, modifier = Modifier
         .fillMaxWidth().height(70.dp)
         .padding(10.dp)) {
         Text("Login", style =
         TextStyle(fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp)
         )
      }


      TextButton(
         onClick = {
          navHostController.navigate(Routes.register.routes){
              popUpTo(navHostController.graph.startDestinationId)
              launchSingleTop = true
          }

         }
      ) {
         Text("New User? Create Account", style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
         )
         )
      }


   }

}




@Preview(showBackground =  true)
@Composable
fun LoginView(){
   //Login()
}