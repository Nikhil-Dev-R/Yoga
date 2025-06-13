package com.rudraksha.yoga.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rudraksha.yoga.data.model.YogaPose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YogaDetailScreen(pose: YogaPose) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(pose.name) })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Level: ${pose.level}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Benefits:", style = MaterialTheme.typography.titleMedium)
            Text(pose.benefits)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
