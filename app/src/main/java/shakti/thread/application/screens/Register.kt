package shakti.thread.application.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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
fun Register(navHostController: NavHostController){
    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var passwrod by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

       Image(
           painter = painterResource(id = R.drawable.uploadimage),
           contentDescription = "My Image",
           modifier = Modifier.height(100.dp).
           width(100.dp).
           clip(CircleShape)
       )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("User Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
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

        OutlinedTextField(value = passwrod,
            onValueChange = {passwrod = it},
            label = { Text("Password") },
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
            Text("Register", style =
            TextStyle(fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp)
            )
        }


        TextButton(
            onClick = { navHostController.navigate(Routes.login.routes){
                popUpTo(navHostController.graph.startDestinationId)
                launchSingleTop = true
            } }
        ) {
            Text("Already register? Login Here", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            )
        }
    }

}




@Preview(showBackground =  true)
@Composable
fun RegisterView(){
}