package com.tech.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.getValue
// for a `var` variable also add
import androidx.compose.runtime.setValue
// or just
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                Column(modifier = Modifier.fillMaxHeight()) {
                    LoginTitle(stringResource(id = R.string.login))
                    LoginUi { username, password ->
                        println("Username: $username, Password: $password")
                    }
                }
            }
        }
    }
}

@Composable
private fun LoginTitle(text: String) {
    /* Here i create column bcz i want two component vertically, Text and Image
    * */
    Column {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            style = TextStyle.Default
        )
        Image(
            painterResource(R.drawable.ic_log), contentDescription = "login",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp)
        )
    }

}

@Composable
private fun LoginUi(onClick: (String, String) -> Unit) {
    var inputValue by remember { mutableStateOf(TextFieldValue()) }
    var inputPass by remember { mutableStateOf(TextFieldValue()) }
    OutlinedCard(modifier = Modifier
        .padding(20.dp, top = 100.dp, end = 20.dp)
        .wrapContentHeight()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(15.dp, top = 50.dp, bottom = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = inputValue,
                onValueChange = { inputValue = it },
                label = { Text("User Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
            )
            OutlinedTextField(
                value = inputPass,
                onValueChange = { inputPass = it },
                textStyle = TextStyle(color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, end = 20.dp)
                    .background(Color.White)
            )
            Text(text = stringResource(id = R.string.forget_pass), fontSize = 14.sp,
                fontWeight = FontWeight.Bold, textAlign = TextAlign.End, modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp, top = 5.dp)
            )


            /*Button Component creation where i use modifier for margin from top, and width fixed 200 and 50dp */
            Button(
                onClick = { onClick(inputValue.text, inputPass.text) }, modifier = Modifier
                    .padding(top = 20.dp)
                    .width(200.dp)
                    .height(50.dp)
            ) {
                Text(text = "Login", fontSize = 20.sp)
            }

        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenPreview() {
    var inputValue by remember { mutableStateOf("dd") }
    JetpackComposeSampleTheme { // This is default app theme, you can check this on Theme file
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Transparent) { // Surface component use for cover full screen and set color transparent
                LoginTitle(stringResource(id = R.string.login)) // Set title from here
                LoginUi { username, password ->
                    println("Username: $username, Password: $password")
            }
        }
    }
}