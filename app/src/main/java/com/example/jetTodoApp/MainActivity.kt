package com.example.jetTodoApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.jetTodoApp.Components.EditDialog
import com.example.jetTodoApp.ui.theme.JetTodoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    val isShowDialog = remember { mutableStateOf(false)}
    if(isShowDialog.value) {
        EditDialog(isShowDialog)
    }

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { isShowDialog.value = true}){
            Icon(imageVector = Icons.Default.Add, contentDescription = "新規作成")
        }
    }) {

    }
}