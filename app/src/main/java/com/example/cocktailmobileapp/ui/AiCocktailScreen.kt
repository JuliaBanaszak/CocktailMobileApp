package com.example.cocktailmobileapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.cocktailmobileapp.services.GeminiService

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AiCocktailScreen(
    onBack: () -> Unit,
    geminiService: GeminiService
) {
    var ingredients by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var generatedRecipe by remember { mutableStateOf("") }
    var shouldGenerate by remember { mutableStateOf(false) } // Trigger flag
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(shouldGenerate) {
        if (shouldGenerate) {
            isLoading = true
            generatedRecipe = geminiService.generateCocktailRecipe(ingredients)
            isLoading = false
            shouldGenerate = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AI Mixologist") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = ingredients,
                onValueChange = { ingredients = it },
                label = { Text("Enter ingredients (comma separated)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    keyboardController?.hide()
                    shouldGenerate = true
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = ingredients.isNotBlank() && !isLoading
            ) {
                Text("Generate Recipe")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            if (generatedRecipe.isNotBlank()) {
                Text(
                    text = generatedRecipe,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}