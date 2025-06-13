package com.eduardo.ejemplo1composeridgs93

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val tarjetas: List<PersonajeTarjeta> =  listOf(
    PersonajeTarjeta("Goku","El protagonista de la serie, conocido por su gran poder y personalidad amigable."),
    PersonajeTarjeta("Vegeta","Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z"),
    PersonajeTarjeta("Piccolo","Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso y miembro de los Guerreros Z"),
    PersonajeTarjeta("Freezer","Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola."),
    PersonajeTarjeta("Bardock","Es un saiyano de clase baja proveniente del Planeta Vegeta del Universo 7. Pertenece al Ejército Saiyano, que está bajo el liderazgo del Rey Vegeta, y es jefe de su escuadrón durante la anexión del planeta por parte de las fuerzas coloniales del Imperio de Freeza."),
    PersonajeTarjeta("Yamcha","Luchador que solía ser un bandido del desierto.")
)
data class  PersonajeTarjeta(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Ejemplo1ComposerIDGS93Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        //ImageHeroe()
        items(personajes){personaje ->
            MyPersonajes(personaje)
        }
    }
}


@Composable
fun MyPersonajes(personaje:PersonajeTarjeta){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {


    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.background)

    ) {
        ImageHeroe(personaje.title)
        Personajes(personaje)
    }
    }
}


@Composable
fun Personaje(name:String, color:Color, style: androidx.compose.ui.text.TextStyle, lines: Int= Int.MAX_VALUE){
    Text(text = name, color = color,style = style, maxLines = lines)
}
@Composable
fun Personajes(personaje: PersonajeTarjeta) {
    var expanded by remember { mutableStateOf (false) }
    Column (
        modifier = Modifier
            .padding(start = 8.dp)
            .clickable { expanded = !expanded }
    ){
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineLarge)

        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
        if(expanded) Int.MAX_VALUE else 1
    }
}
@Composable
fun ImageHeroe(imageName: String){
    val contex = LocalContext.current
    val imageResId= remember (imageName){
        contex.resources.getIdentifier(imageName.lowercase(),"drawable",contex.packageName)
    }
    Image(painter = painterResource(id = imageResId), contentDescription = null,
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.error))

}

@Preview
@Composable
fun GreetingPreview() {
    Tarjeta(tarjetas)
    }