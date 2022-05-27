package com.example.tipcalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.components.InputText
import com.example.tipcalculator.components.RoundedCircle
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .fillMaxHeight(), verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeaderLevel()
                    Divider()
                    ContentLevel() { inputAmount ->
                        Log.d("new", "onCreate: ${inputAmount.trim()}")
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderLevel(total: Double = 120.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(15.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        color = Color.LightGray,
        elevation = 10.dp,
        border = BorderStroke(width = 1.dp, color = Color.Gray)

    ) {
        val totalPerson = "%.2f".format(total)
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total per Person",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "$$totalPerson",
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ContentLevel(onValueChange: (String) -> Unit) {
    val totalBillsState = remember {
        mutableStateOf("")
    }
    val validState = remember(totalBillsState.value) {
        totalBillsState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(15.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 10.dp,
        border = BorderStroke(width = 1.dp, color = Color.Gray)

    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputText(
                // totalBillsState is == metatablesOf<String>
                valueState = totalBillsState,
                labelId = "Enter Bills",
                isEnable = true,
                isSingle = true,
                onAction = KeyboardActions {
                    //checking if the totallyState is Not valid
                    if (!validState) return@KeyboardActions
                    //TODO
                    onValueChange(totalBillsState.value.trim())
                    // TODO HIDE KEYBOARD
                    keyboardController?.hide()
                })
            if (validState) {
                val valueState = remember {
                    mutableStateOf("")
                }
//                WorkedNew(newContent = valueState.value){
//                    valueState.value = it
//                }

            } else {
                Box {}
            }
        }
    }
}

@Composable
private fun WorkedNew(newContent:String,onValueChange: (String) -> Unit) {

    //Show the details of the tips
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Split", modifier = Modifier, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.width(120.dp))
        Row(
            modifier = Modifier.padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.End
        ) {
            RoundedCircle(imageVector = Icons.Default.Add, onClick = {})
            Text(
                text = newContent,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.h4
            )
            onValueChange(newContent.trim())
            RoundedCircle(imageVector = Icons.Default.Refresh, onClick = {})
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        HeaderLevel()
    }
}