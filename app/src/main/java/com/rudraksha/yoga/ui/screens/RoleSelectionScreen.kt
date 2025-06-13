package com.rudraksha.yoga.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleSelectionScreen(onRoleSelected: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("YogaGram") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Choose your Role", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { onRoleSelected("Sarpanch") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sarpanch")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { onRoleSelected("User") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("User")
            }
        }
    }
}
