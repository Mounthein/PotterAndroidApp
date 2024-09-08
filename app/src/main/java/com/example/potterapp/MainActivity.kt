package com.example.potterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.potterapp.common.ScreenRoutes
import com.example.potterapp.domain.model.CharacterDetail
import com.example.potterapp.domain.model.CharacterSimple
import com.example.potterapp.presentation.character_detail.CharacterDetailScreen
import com.example.potterapp.presentation.character_list.components.CharacterListScreen
import com.example.potterapp.ui.theme.PotterAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PotterAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenRoutes.Start
                ){
                    composable(route = ScreenRoutes.Start.name){
                        CharacterListScreen(navController = navController)
                    }
                    composable(route = ScreenRoutes.Detail.name + "/{characterId}") {
                        CharacterDetailScreen(navController = navController)
                    }
                }
                }
            }
        }
    }


@Serializable
object ScreenA

@Serializable
data class  ScreenB(
    val name: String?,
    val age: Int
)


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PotterAppTheme {
        Greeting("Android")
    }
}