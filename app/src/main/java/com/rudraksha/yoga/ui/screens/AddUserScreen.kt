package com.rudraksha.yoga.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rudraksha.yoga.data.model.*
import com.rudraksha.yoga.data.model.enums.Gender
import com.rudraksha.yoga.data.model.enums.Goal
import com.rudraksha.yoga.data.model.enums.PhysicalLevel
import com.rudraksha.yoga.ui.components.DropdownSelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(onSubmit: (UserProfile) -> Unit) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf(Gender.MALE) }
    var physicalLevel by remember { mutableStateOf(PhysicalLevel.MEDIUM) }
    var goal by remember { mutableStateOf(Goal.GENERAL_FITNESS) }

    Scaffold(topBar = { TopAppBar(title = { Text("Add User") }) }) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {

            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age") }, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(8.dp))
            DropdownSelector("Gender",
                Gender.entries.toTypedArray(), gender, onSelect = { gender = it })
            DropdownSelector("Physical Activity",
                PhysicalLevel.entries.toTypedArray(), physicalLevel, onSelect = { physicalLevel = it })
            DropdownSelector("Goal", Goal.entries.toTypedArray(), goal, onSelect = { goal = it })

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (name.isNotEmpty() && age.isNotEmpty()) {
                    onSubmit(UserProfile(0, name, age.toInt(), gender, "", physicalLevel, goal))
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Submit")
            }
        }
    }
}
