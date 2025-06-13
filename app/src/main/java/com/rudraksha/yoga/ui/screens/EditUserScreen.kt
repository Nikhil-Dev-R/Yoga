package com.rudraksha.yoga.ui.screens

import androidx.compose.runtime.Composable
import com.rudraksha.yoga.data.model.UserProfile
import com.rudraksha.yoga.ui.AddUserScreen

@Composable
fun EditUserScreen(existing: UserProfile, onSubmit: (UserProfile) -> Unit) {
    AddUserScreen(onSubmit = onSubmit)
}
