package com.prado.toobar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prado.toobar.ui.theme.TooBarTheme
import com.prado.toobar.util.SearchAppBarState
import com.prado.toobar.util.SharedViewModel

class MainActivity : ComponentActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TooBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
                    val searchTextState: String by sharedViewModel.searchTextState
                    Greeting(
                        sharedViewModel = sharedViewModel,
                        searchAppBarState = searchAppBarState,
                        searchTextState = searchTextState
                    )
                }
            }
        }
    }
}




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Greeting(
    sharedViewModel: SharedViewModel,
    searchAppBarState: SearchAppBarState,
    searchTextState: String
) {

    Scaffold(topBar = {
        CustomTopAppBar(
            sharedViewModel = sharedViewModel,
            searchAppBarState = searchAppBarState,
            searchTextState = searchTextState
        )
    }) {

    }

    Text(modifier = Modifier.padding(top = 90.dp), text = "Hello There!")
}

