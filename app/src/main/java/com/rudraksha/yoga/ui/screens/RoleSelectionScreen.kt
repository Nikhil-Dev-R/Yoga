package com.rudraksha.yoga.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rudraksha.yoga.data.model.UserProfile
import com.rudraksha.yoga.data.model.YogaPose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleSelectionScreen(onRoleSelected: (String) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("YogaGram") }) }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Select Role", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { onRoleSelected("Sarpanch") }, modifier = Modifier.fillMaxWidth()) {
                Text("Sarpanch")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onRoleSelected("User") }, modifier = Modifier.fillMaxWidth()) {
                Text("User")
            }
        }
    }
}

