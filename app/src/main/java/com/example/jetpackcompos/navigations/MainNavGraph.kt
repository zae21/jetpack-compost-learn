package com.example.jetpackcompos.navigations

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.jetpackcompos.screens.DetailScreen
import com.example.jetpackcompos.screens.HomeScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = MAIN_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAIL_ARG_KEY) {
                type = NavType.IntType
                defaultValue = 0
            })
        ) {
            val id = it.arguments?.getInt(DETAIL_ARG_KEY)
            DetailScreen(navController = navController, id = id ?: 0)
        }
    }
}