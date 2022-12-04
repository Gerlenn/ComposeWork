package com.example.composeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    SetColumn()
                }
            }
        }
    }
}

@Composable
fun SetColumn() {
    var remembered by remember { mutableStateOf("") }
    var remembered2 by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(PaddingValues(top = 80.dp, start = 50.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "",
            modifier = Modifier.requiredSize(250.dp),
        )

        TextField(
            value = remembered,
            onValueChange = {
                remembered = it
            },
            label = {
                Text(text = "Enter yor name")
            }
        )
        TextField(
            value = remembered2,
            onValueChange = {
                remembered2 = it
            },
            label = {
                Text(text = "Enter yor password")
            }
        )

        Column() {

        }
        val context = LocalContext.current
        Button(
            onClick = {
                if (remembered.toString().isEmpty()) {
                    Toast.makeText(context, "Invalid name", Toast.LENGTH_SHORT).show()
                } else if (remembered2.toString().isEmpty()) {
                    Toast.makeText(context, "Invalid password", Toast.LENGTH_SHORT).show()
                } else
                Toast.makeText(context, "Login completed!!! \nname: $remembered\npassword: $remembered2", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(PaddingValues(top = 50.dp, end = 80.dp))
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(
                text = "LogIn",
            )
        }
    }
}


