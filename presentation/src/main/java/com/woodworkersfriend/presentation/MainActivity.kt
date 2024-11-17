package com.woodworkersfriend.presentation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.activity.viewModels
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.animation.doOnEnd
import com.woodworkersfriend.presentation.common.BottomNavigationItem
import com.woodworkersfriend.presentation.common.composables.custom.sharedelements.SharedElementsRoot
import com.woodworkersfriend.presentation.models.Screen
import com.woodworkersfriend.presentation.ui.functionslist.FunctionsListViewModel
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase03
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase3
import com.woodworkersfriend.presentation.ui.theme.WoodworkersFriendTheme
import com.woodworkersfriend.presentation.ui.theme.setNavigationBarContainerColors
import com.woodworkersfriend.presentation.ui.theme.setNavigationBarContentColors
import com.woodworkersfriend.presentation.ui.theme.setNavigationBarItemColors
import com.woodworkersfriend.presentation.ui.theme.setThemeColor
import dagger.hilt.android.AndroidEntryPoint
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.popAll
import dev.olshevski.navigation.reimagined.rememberNavController
import kotlin.getValue
import com.woodworkersfriend.presentation.ui.boardfootcalculator.BoardFootCalculatorScreen
import com.woodworkersfriend.presentation.ui.functionslist.FunctionsListScreen
import com.woodworkersfriend.presentation.ui.unitconversion.UnitConversionScreen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val startDestinationViewModel: FunctionsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WoodworkersFriendTheme {
                val navController = rememberNavController<Screen>(
                    startDestination = Screen.FunctionsList
                )

                NavBackHandler(navController)

                val isBackStackEmpty by remember {
                    derivedStateOf {
                        navController.backstack.entries.size == 1
                    }
                }

                BackHandler(enabled = isBackStackEmpty) {
                    finish()
                }

                val currentDestination by remember {
                    derivedStateOf {
                        navController.backstack.entries.first().destination
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0.dp),
                    containerColor = setThemeColor(SolarizedBase3, SolarizedBase03),
                    bottomBar = {
                        NavigationBar(
                            containerColor = setNavigationBarContainerColors(),
                            contentColor = setNavigationBarContentColors()
                        ) {
                            BottomNavigationItem.entries.forEach { item ->
                                NavigationBarItem(
                                    icon = { Icon(item.icon, contentDescription = stringResource(id = item.title)) },
                                    label = { Text(stringResource(id = item.title)) },
                                    selected = item.route == currentDestination,
                                    colors = setNavigationBarItemColors(),
                                    onClick = {
                                        if (item.route != currentDestination) {
                                            navController.popAll()
                                            navController.navigate(item.route)
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->

                    Surface(modifier = Modifier.padding(innerPadding)) {
                        SharedElementsRoot {
                            NavHost(
                                controller = navController,
                                //transitionSpec = mainNavHostTransitionSpec
                            ) { route ->
                                when (route) {
                                    is Screen.FunctionsList -> { FunctionsListScreen(navController = navController, viewModel = startDestinationViewModel) }
                                    is Screen.BoardFootCalculator -> { BoardFootCalculatorScreen(navController = navController) }
                                    is Screen.UnitConversion -> { UnitConversionScreen(navController = navController) }
//                                    is Screen.Search -> { SearchScreen(navController = navController) }
//                                    is Screen.Help -> { HelpScreen(navController = navController) }
                                    is Screen.Settings -> { UnitConversionScreen(navController = navController) }
//                                    is Screen.About -> {
//                                        AboutScreen(
//                                            navController = navController,
//                                            playStoreCoinTrendPackageName = packageName,
//                                            onLinkClick = { url ->
////                                                this@MainActivity.openUrlInExternalBrowser(url = url)
//                                            },
//                                            onEmailClick = { email, subject ->
////                                                this@MainActivity.openEmailInExternalApp(
////                                                    toEmailAddresses = setOf(email),
////                                                    subject = subject
////                                                )
//                                            },
//                                            onPlayStoreClick = {
////                                                openAppInPlayStore(packageName = packageName)
//                                            }
//                                        )
//                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        installSplashScreen().apply {
//            setKeepOnScreenCondition {
//                startDestinationViewModel.state.topCoinsList.isEmpty() &&
//                        startDestinationViewModel.state.state !is CoinsListUiState.Error
//            }

            setOnExitAnimationListener { screen ->
                val fade = ObjectAnimator.ofFloat(
                    screen.view,
                    View.ALPHA,
                    1f,
                    0f
                ).apply {
                    interpolator = AccelerateInterpolator()
                    duration = 150L
                    doOnEnd { screen.remove() }
                }

                fade.start()
            }
        }

        viewModel.init()
    }
}
