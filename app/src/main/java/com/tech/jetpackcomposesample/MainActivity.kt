package com.tech.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.TextStyle
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
                logButton { username, password ->
                    println("Username: $username, Password: $password")
                }
            }
        }
    }
}

@Composable
private fun loginUI(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        style = TextStyle.Default
    )

}

@Composable
private fun logButton(onClick: (String, String) -> Unit) {
    var inputValue by remember { mutableStateOf(TextFieldValue()) }
    var inputPass by remember { mutableStateOf(TextFieldValue()) }
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(15.dp, top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
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
        Button(
            onClick = { onClick(inputValue.text, inputPass.text) }, modifier = Modifier
                .padding(top = 10.dp)
                .width(200.dp)
                .height(50.dp)
        ) {
            Text(text = "Login", fontSize = 20.sp)
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenPreview() {
    var inputValue by remember { mutableStateOf("dd") }
    JetpackComposeSampleTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
            loginUI("Airtel Payment Bank")
            logButton { username, password ->
                println("Username: $username, Password: $password")
            }
        }
    }
}