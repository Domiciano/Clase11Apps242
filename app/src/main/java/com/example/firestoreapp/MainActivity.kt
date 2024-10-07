package com.example.firestoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firestoreapp.ui.theme.FirestoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirestoreAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App(mainViewModel: MainViewModel = viewModel()){

    LaunchedEffect(true) {
        mainViewModel.query1("Colombia", 0, 10000000)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

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
    FirestoreAppTheme {
        Greeting("Android")
    }
}

data class City(
    var id: String = "",
    var country: String = "",
    var city: String = "",
    var population: Int = 0,
    var area:Double=0.0,
    var sectors: ArrayList<String> = arrayListOf()
)