package com.rudraksha.yoga.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rudraksha.yoga.ui.AddUserScreen
import com.rudraksha.yoga.ui.RoleSelectionScreen
import com.rudraksha.yoga.ui.screens.FeedbackScreen
import com.rudraksha.yoga.ui.screens.OnboardingScreen
import com.rudraksha.yoga.ui.screens.SarpanchDashboard
import com.rudraksha.yoga.ui.screens.SettingsScreen
import com.rudraksha.yoga.ui.screens.SplashScreen

@Composable
fun YogaNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Splash
    ) {
        composable(Route.Splash) {
            SplashScreen { navController.navigate(Route.Onboarding) }
        }
        composable(Route.Onboarding) {
            OnboardingScreen { navController.navigate(Route.RoleSelection) }
        }
        composable(Route.RoleSelection) {
            RoleSelectionScreen { role ->
                if (role == "Sarpanch") navController.navigate(Route.SarpanchDashboard)
                else navController.navigate(Route.YogaSuggestion)
            }
        }
        composable(Route.SarpanchDashboard) {
            SarpanchDashboard(
                profiles = listOf(), // Replace with real data source
                onAddUser = { navController.navigate(Route.AddUser) },
                onUserClick = { navController.navigate(Route.EditUser) }
            )
        }
        composable(Route.AddUser) {
            AddUserScreen { navController.popBackStack() }
        }
        composable(Route.EditUser) {
            // Replace with actual user object
            // EditUserScreen(existing = DummyData.sampleUser) { navController.popBackStack() }
        }
        composable(Route.YogaSuggestion) {
            // YogaSuggestionScreen(poses = DummyData.sampleYogaPoses) {
            //     navController.navigate(Route.YogaDetail)
            // }
        }
        composable(Route.YogaDetail) {
            // YogaDetailScreen(pose = DummyData.samplePose)
        }
        composable(Route.Feedback) {
            FeedbackScreen { navController.popBackStack() }
        }
        composable(Route.Settings) {
            SettingsScreen { navController.navigate(Route.RoleSelection) }
        }
    }
}
