package com.rudraksha.yoga.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rudraksha.yoga.data.model.UserProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SarpanchDashboard(
    profiles: List<UserProfile>,
    onAddUser: () -> Unit,
    onUserClick: (UserProfile) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddUser) {
                Icon(Icons.Default.Add, contentDescription = "Add User")
            }
        },
        topBar = { TopAppBar(title = { Text("Sarpanch Dashboard") }) }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(profiles) { profile ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onUserClick(profile) },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(profile.name, style = MaterialTheme.typography.titleMedium)
                        Text("${profile.age} yrs | ${profile.gender.name}")
                        Text("Goal: ${profile.goals.name.replace("_", " ")}")
                    }
                }
            }
        }
    }
}