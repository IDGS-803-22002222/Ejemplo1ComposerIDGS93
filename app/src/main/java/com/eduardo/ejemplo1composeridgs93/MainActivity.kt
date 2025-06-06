package com.eduardo.ejemplo1composeridgs93

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eduardo.ejemplo1composeridgs93.ui.theme.Ejemplo1ComposerIDGS93Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
Tarjeta()
        }
    }
}

@Composable
fun Tarjeta(){
    Row {
        ImageHeroe()
        Personaje()
    }
}

@Composable
fun Personaje(){
    Column {
    Text("Hola soy Gohan")
    Text("Soy Goku")
    }
}

@Composable
fun ImageHeroe(){
    Image(painter = painterResource(id = R.drawable.goku_normal), contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.Gray))

}

@Preview
@Composable
fun GreetingPreview() {
    Tarjeta()
    }