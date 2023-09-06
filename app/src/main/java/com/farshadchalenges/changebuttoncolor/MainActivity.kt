@file:OptIn(ExperimentalMaterial3Api::class)

package com.farshadchalenges.changebuttoncolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farshadchalenges.changebuttoncolor.ui.theme.ChangeButtonColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeButtonColorTheme {
                ChangeColor()
            }
        }
    }
}

@Composable
fun ChangeColor() {
    Scaffold(

    ) {
        Column(modifier = Modifier.padding(it)) {

            val myButtonBackGroundColor = remember {
                mutableStateOf(Color.Blue)
            }
            val myButtonTextColor = remember {
                mutableStateOf(Color.Black)
            }
            val myBackGroundColor = remember {
                mutableStateOf(Color.DarkGray)
            }
            val myButtonText = remember {
                mutableStateOf("Do your Magic")
            }
            val myText = remember {
                mutableStateOf("Show Your message Here")
            }
            val showOrHide = remember {
                mutableStateOf(true)
            }
            val myTextFieldValue = remember {
                mutableStateOf("")
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(myBackGroundColor.value),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (!showOrHide.value) {
                    Text(
                        text = myTextFieldValue.value,
                        fontSize = 24.sp,
                        color = myButtonTextColor.value,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .background(myButtonBackGroundColor.value)
                    )
                }

                Spacer(modifier = Modifier.size(20.dp))

                Button(
                    onClick = {
                        if (showOrHide.value) {
                            myButtonBackGroundColor.value = Color.Red
                            myButtonTextColor.value = Color.Yellow
                            myBackGroundColor.value = Color.White
                            myButtonText.value = "You did it"
                            showOrHide.value = false
                        } else {
                            myButtonBackGroundColor.value = Color.Blue
                            myButtonTextColor.value = Color.Black
                            myBackGroundColor.value = Color.DarkGray
                            myButtonText.value = "Do Your Magic"
                            myTextFieldValue.value = ""
                            showOrHide.value = true
                        }

                    },
                    modifier = Modifier.size(250.dp, 100.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = myButtonBackGroundColor.value
                    ),
                    border = BorderStroke(3.dp, Color.DarkGray)
                ) {
                    Text(
                        text = myButtonText.value,
                        color = myButtonTextColor.value,
                        fontSize = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))

                TextField(
                    value = myTextFieldValue.value,
                    onValueChange = {
                        myTextFieldValue.value = it
                    },
                    label = {
                        Text(
                            text = "Enter Your Name",
                            color = Color.Blue
                        )
                    },
                    modifier = Modifier.width(300.dp),
                    maxLines = 4
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChangeColorPreview() {
    ChangeButtonColorTheme {
        ChangeColor()
    }
}