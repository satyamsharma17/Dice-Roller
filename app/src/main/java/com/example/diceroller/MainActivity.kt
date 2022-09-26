package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
               DiceRollerApp()
            }
        }
    }
}


@Preview
@Composable
fun ComposeCamp() {
    JetPackCompose(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun JetPackCompose(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.jetcompose),
            contentDescription = null,
            modifier = Modifier.clip(RoundedCornerShape(10.dp)),
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = stringResource(R.string.compose_camp),
            fontSize = 16.sp,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {

            Text(
                text = stringResource(R.string.compose_button),
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

fun rollDice(): Int {
    return (1..6).random()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        text view
        Text(
            text = stringResource(R.string.title),
            fontSize = 26.sp,
        )
//        space view
        Spacer(
            modifier = Modifier.height(16.dp)
        )
//        image view
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
//        space view
        Spacer(
            modifier = Modifier.height(16.dp)
        )
//        button view
        Button(
            onClick = { result = rollDice() }) {
            Text(
                text = stringResource(R.string.roll),
                fontSize = 24.sp
            )
        }
    }
}