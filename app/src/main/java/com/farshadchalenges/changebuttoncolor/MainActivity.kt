@file:OptIn(ExperimentalMaterial3Api::class)

package com.farshadchalenges.changebuttoncolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
            val myButtonContentColor = remember {
                mutableStateOf(Color.Black)
            }
            val myBackGroundColor = remember {
                mutableStateOf(Color.LightGray)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(myBackGroundColor.value),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(
                    onClick = {
                        myButtonBackGroundColor.value = Color.Red
                        myButtonContentColor.value = Color.Yellow
                        myBackGroundColor.value = Color.White
                    },
                    modifier = Modifier.size(250.dp, 100.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = myButtonBackGroundColor.value,
                        contentColor = myButtonContentColor.value
                    ),
                    border = BorderStroke(3.dp, Color.DarkGray)

                ) {
                    Text(
                        text = "Do your Magic",
                        fontSize = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End
                    )
                }
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