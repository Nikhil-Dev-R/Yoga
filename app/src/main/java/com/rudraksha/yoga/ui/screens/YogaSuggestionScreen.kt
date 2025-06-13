package com.rudraksha.yoga.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rudraksha.yoga.data.model.UserProfile
import com.rudraksha.yoga.data.model.YogaPose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YogaSuggestionScreen(
    user: UserProfile,
    poses: List<YogaPose>,
    onPoseClick: (YogaPose) -> Unit
) {
    Scaffold(topBar = { TopAppBar(title = { Text("Yoga Suggestions") }) }) {
        Column(modifier = Modifier.padding(it).padding(16.dp)) {
            Text("Hello ${user.name}, here are your yoga recommendations:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items (poses) { pose ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        onClick = { onPoseClick(pose) },
                        elevation = CardDefaults.cardElevation()
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(pose.name, style = MaterialTheme.typography.titleLarge)
                            Text(pose.benefits, maxLines = 2, overflow = TextOverflow.Ellipsis)
                        }
                    }
                }
            }
        }
    }
}