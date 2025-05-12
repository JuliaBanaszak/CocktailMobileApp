package com.example.cocktailmobileapp

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailDetailScreen(cocktail: Cocktail, onBack: () -> Unit, modifier: Modifier = Modifier) {
    val details = cocktailDetails[cocktail.name] ?: return
    val context = LocalContext.current

    var timeLeft by remember { mutableStateOf(60) }
    var isRunning by remember { mutableStateOf(false) }

    LaunchedEffect(isRunning, timeLeft) {
        if (isRunning && timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(cocktail.name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Wstecz"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            if (details.ingredients.isNotBlank()) {
                FloatingActionButton(
                    onClick = {
                        val message = "Składniki:\n" + details.ingredients.replace(", ", "\n")
                        val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("smsto:")
                            putExtra("sms_body", message)
                        }
                        context.startActivity(smsIntent)
                    }
                ) {
                    Icon(Icons.Default.Send, contentDescription = "Wyślij SMS")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(paddingValues)
                .navigationBarsPadding()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = cocktail.imageResId),
                        contentDescription = cocktail.name,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Składniki:", fontWeight = FontWeight.Bold)
            Text(details.ingredients.replace(", ", "\n"))

            Spacer(modifier = Modifier.height(20.dp))

            Text("Przygotowanie:", fontWeight = FontWeight.Bold)
            details.preparation.split("\\d+\\. ".toRegex())
                .filter { it.isNotBlank() }
                .forEachIndexed { index, step ->
                    Text("${index + 1}. $step")
                }

            Spacer(modifier = Modifier.height(16.dp))

            val minutesLeft = timeLeft / 60
            val secondsLeft = timeLeft % 60

            Text(
                text = "%02d:%02d".format(minutesLeft, secondsLeft),
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            var inputMinutes by remember { mutableStateOf(minutesLeft.toString()) }
            var inputSeconds by remember { mutableStateOf(secondsLeft.toString()) }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = inputMinutes,
                    onValueChange = {
                        if (it.all { ch -> ch.isDigit() }) {
                            inputMinutes = it
                            timeLeft = (inputMinutes.toIntOrNull() ?: 0) * 60 + (inputSeconds.toIntOrNull() ?: 0)
                        }
                    },
                    label = { Text("Minuty") },
                    modifier = Modifier.width(100.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = inputSeconds,
                    onValueChange = {
                        if (it.all { ch -> ch.isDigit() }) {
                            inputSeconds = it
                            timeLeft = (inputMinutes.toIntOrNull() ?: 0) * 60 + (inputSeconds.toIntOrNull() ?: 0)
                        }
                    },
                    label = { Text("Sekundy") },
                    modifier = Modifier.width(100.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { isRunning = true }) { Text("Start") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { isRunning = false }) { Text("Pauza") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {
                    timeLeft = 60
                    inputMinutes = "1"
                    inputSeconds = "00"
                }) { Text("Reset") }
            }
        }
    }
}