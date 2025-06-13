package com.rudraksha.yoga.ui.screens// FeedbackScreen.kt - To be populated

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreen(onSubmit: (String) -> Unit) {
    var feedback by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Feedback") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = feedback,
                onValueChange = { feedback = it },
                label = { Text("Write your feedback") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { if (feedback.isNotEmpty()) onSubmit(feedback) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}
