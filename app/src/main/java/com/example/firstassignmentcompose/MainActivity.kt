package com.example.firstassignmentcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
         PokemonList()
        }
    } }

@Composable
fun CardItem(modifier: Modifier = Modifier.padding(vertical = 10.dp),pokemonDetails: PokemonDetails) {


        ElevatedCard(

            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp

            ),
            colors = CardDefaults.cardColors(pokemonDetails.cardColor),

            modifier = Modifier
                .size(width = 350.dp, height = 160.dp)
                .padding(vertical = 8.dp)
        )
        {
            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val (title, type, attack, defense, pokemonImage) = createRefs()
                Text(
                    text = pokemonDetails.title,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .constrainAs(title) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)

                        }
                        .padding(8.dp),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = pokemonDetails.type,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .padding(start = 20.dp, top = 8.dp, end = 8.dp)
                        .constrainAs(type) {
                            start.linkTo(title.start)
                            top.linkTo(title.bottom)
                        }

                        .background(
                            color = pokemonDetails.typeColor, shape = RoundedCornerShape(50),
                        )
                        .padding(8.dp) ,
                    textAlign = TextAlign.Start,

                    )
                Text(
                    text = "attack :  ${pokemonDetails.attack}",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .constrainAs(attack) {
                            start.linkTo(title.end)
                            start.linkTo(type.end)
                            top.linkTo(title.bottom)
                        }
                        .padding(horizontal = 10.dp),
                    textAlign = TextAlign.Start,

                    )
                Text(
                    text = "defense : ${pokemonDetails.defense}",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .constrainAs(defense) {
                            start.linkTo(attack.start)

                            top.linkTo(attack.bottom)
                        }
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                    textAlign = TextAlign.Start,

                    )
                Image(
                    painter = painterResource(id = pokemonDetails.Image),

                    contentDescription = "Pokemon Image",

                    modifier = Modifier
                        .padding(16.dp)
                        .constrainAs(pokemonImage) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)

                        }
                        .padding(start = 100.dp)
                        .background(

                            shape = CircleShape,
                            color = colorResource(
                                id = R.color.grayy
                            )
                        )
                        .size(100.dp)
                        .clip(CircleShape) )

            }

        }

    }
@Preview(showSystemUi = true)
@Composable
private fun CardItemPreview() {
    CardItem(pokemonDetails = PokemonDetails("pokemon" ,"",65,
        65 ,R.drawable.bulbasaur ,Color(0xFF0D47A1),Color(0xFF0D47A1)),)
}





    val pokemons = listOf(
        PokemonDetails("Bulbasaur", "grass", 65, 65 ,R.drawable.
        bulbasaur ,Color(0xFF4CAF50) , Color(0xFF1B5E20)),
        PokemonDetails("Ivysaur", "grass", 80, 80 ,R.drawable.ivysaur
            ,Color(0xFF388E3C), Color(0xFF4CAF50)),
        PokemonDetails("Venusaur", "grass", 122, 120 ,R.drawable.venusaur
            ,Color(0xFF1B5E20), Color(0xFF4CAF50)),
        PokemonDetails("Charmander", "fire", 60, 50,R.drawable.charmander,
            Color(0xFFFF5722),Color(0xFFD32F2F)),
        PokemonDetails("Charmeleon", "fire", 80, 65,R.drawable.charmeleon
            ,Color(0xFFF57C00),Color(0xFFFF5722)),
        PokemonDetails("Charizard", "fire", 159, 115,R.drawable.charizard,
            Color(0xFFD32F2F),Color(0xFFFF5722)),
        PokemonDetails("Squirtle", "water", 50, 64,R.drawable.squirtle,
            Color(0xFF2196F3), Color(0xFF0D47A1)),
        PokemonDetails("Wartortle", "water", 65, 80,R.drawable.wartortle,
            Color(0xFF1976D2), Color(0xFF2196F3)),
        PokemonDetails("Blastoise", "water", 135, 115,R.drawable.blastoise,
            Color(0xFF0D47A1), Color(0xFF2196F3)),
        PokemonDetails("Bulbasaur", "grass", 65, 65 ,R.drawable.
        bulbasaur ,Color(0xFF4CAF50) , Color(0xFF1B5E20)),
        PokemonDetails("Ivysaur", "grass", 80, 80 ,R.drawable.ivysaur
            ,Color(0xFF388E3C), Color(0xFF4CAF50)),
        PokemonDetails("Venusaur", "grass", 122, 120 ,R.drawable.venusaur
            ,Color(0xFF1B5E20), Color(0xFF4CAF50)),
        PokemonDetails("Charmander", "fire", 60, 50,R.drawable.charmander,
            Color(0xFFFF5722),Color(0xFFD32F2F)),
        PokemonDetails("Charmeleon", "fire", 80, 65,R.drawable.charmeleon
            ,Color(0xFFF57C00),Color(0xFFFF5722)),
        PokemonDetails("Charizard", "fire", 159, 115,R.drawable.charizard,
            Color(0xFFD32F2F),Color(0xFFFF5722)),
        PokemonDetails("Squirtle", "water", 50, 64,R.drawable.squirtle,
            Color(0xFF2196F3), Color(0xFF0D47A1)),
        PokemonDetails("Wartortle", "water", 65, 80,R.drawable.wartortle,
            Color(0xFF1976D2), Color(0xFF2196F3)),
        PokemonDetails("Blastoise", "water", 135, 115,R.drawable.blastoise,
            Color(0xFF0D47A1), Color(0xFF2196F3)),

    )




@Preview(showBackground = true)
@Composable
fun PreviewPokemonList() {

}

@Composable
fun PokemonList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        items(pokemons) { pokemon ->
            CardItem(pokemonDetails =  pokemon)
        }
    }
}
