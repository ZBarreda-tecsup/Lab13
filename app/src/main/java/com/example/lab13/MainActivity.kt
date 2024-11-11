package com.example.lab13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab13.ui.theme.Lab13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimatedBoxWithButton()
        }
    }
}
@Composable
fun AnimatedBoxWithButton() {
    val isExpanded = remember { mutableStateOf(false) }

    val offsetX by animateDpAsState(
        targetValue = if (isExpanded.value) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )

    val boxSize by animateDpAsState(
        targetValue = if (isExpanded.value) 150.dp else 80.dp,
        animationSpec = tween(durationMillis = 500)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset(x = offsetX, y = 0.dp)
                .size(boxSize)
                .background(Color.Blue)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { isExpanded.value = !isExpanded.value }) {
            Text(text = "Mover y Cambiar Tamaño")
        }
    }
}

/**
@Composable
fun ButtonVisibility() {
    var isVisible by remember { mutableStateOf(false)}
    val isBlue = remember { mutableStateOf(true) }
    val backgroundColor by animateColorAsState(
        targetValue = if (isBlue.value) Color.Blue else Color.Green,
        animationSpec = spring(dampingRatio = 10f)  // Duración de 1 segundo
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ){
        Button(onClick ={isVisible = !isVisible}){
            Text(text = if (isVisible) "Ocultar cuadro" else "Mostrar cuadro")
        }

        Spacer(modifier = Modifier.height(6.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(tween(500))
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(backgroundColor)
                    .clickable { isBlue.value = !isBlue.value }
            )
        }

    }
}
**/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}