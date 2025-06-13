package com.rudraksha.yoga.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rudraksha.yoga.data.model.UserProfile
import com.rudraksha.yoga.data.model.enums.Gender
import com.rudraksha.yoga.data.model.enums.Goal
import com.rudraksha.yoga.data.model.enums.PhysicalLevel
import com.rudraksha.yoga.ui.*
import com.rudraksha.yoga.ui.screens.RoleSelectionScreen
import com.rudraksha.yoga.ui.screens.SarpanchDashboard
import com.rudraksha.yoga.ui.screens.YogaSuggestionScreen

@Composable
fun YogaNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "role_selection") {
        composable("role_selection") {
            RoleSelectionScreen { role ->
                if (role == "Sarpanch") navController.navigate("dashboard")
                else navController.navigate("suggestion")
            }
        }
        composable("dashboard") {
            SarpanchDashboard(profiles = listOf(), onAddUser = {}, onUserClick = {})
        }
        composable("suggestion") {
            YogaSuggestionScreen(user = UserProfile(0, "Demo", 30, Gender.MALE, "", PhysicalLevel.LOW, Goal.GENERAL_FITNESS), poses = listOf(), onPoseClick = {})
        }
    }
}