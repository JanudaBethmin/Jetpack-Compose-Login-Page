package io.januda.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.januda.login.ui.theme.LoginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image()
                Column (
                    modifier = Modifier
                        .border(BorderStroke(1.dp, SolidColor(Color.Black)))
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .shadow(1.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Greeting()
                    TextFieldEmail()
                    TextFieldPassword()
                    Hyperlink()
                    LoginButton { Log.i("info", "You have logged in") }
                    Text(
                        text ="- or login with -",
                        modifier = Modifier.padding(20.dp),
                    )
                    Row {
                        GoogleLoginButton { Log.i("info", "You have logged in using Google") }
                        Text("      ")
                        FaceBookLoginButton { Log.i("info", "You have logged in using Facebook") }
                    }
                }
            }
        }
    }
}

@Composable
fun Image() {
    Image(
        painter = painterResource(id = R.drawable.beach),
        contentDescription = "Beach",
        modifier = Modifier
            .padding(bottom = 10.dp)
            .clip(shape = RoundedCornerShape(8.dp))
    )
}

@Composable
fun Greeting() {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top= 0.dp)
        )
    }
}

@Composable
fun TextFieldEmail() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = email,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            email = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
        modifier = Modifier.padding(top= 20.dp)
    )
}

@Composable
fun TextFieldPassword() {
    var password by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = password,
        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "passwordIcon") },
        onValueChange = {
            password = it
        },
        visualTransformation = PasswordVisualTransformation(),
        label = { Text(text = "Password") },
        placeholder = { Text(text = "Enter your password") },
        modifier = Modifier.padding(top= 20.dp)
    )

}

@Composable
fun Hyperlink() {
    ClickableText(
        text = AnnotatedString("Forgot Password?"),
        modifier = Modifier.padding(top= 20.dp,bottom=20.dp),
        onClick = {Log.i("info", "You have forgot your password") }
    )
}

@Composable
fun LoginButton(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Icon(imageVector = Icons.Default.Person, contentDescription = "passwordIcon")
        Text(" Login")
    }
}

@Composable
fun GoogleLoginButton(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Icon(imageVector = Icons.Default.Person, contentDescription = "passwordIcon")
        Text(" Google")
    }
}

@Composable
fun FaceBookLoginButton(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Icon(imageVector = Icons.Default.Person, contentDescription = "passwordIcon")
        Text(" Facebook")
    }
}




