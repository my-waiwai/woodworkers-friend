package com.woodworkersfriend.presentation.ui.functionslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.woodworkersfriend.presentation.R
import com.woodworkersfriend.presentation.common.DEFAULT_HORIZONTAL_PADDING
import com.woodworkersfriend.presentation.common.DEFAULT_VERTICAL_PADDING
import com.woodworkersfriend.presentation.models.Screen
import com.woodworkersfriend.presentation.ui.icons.Calculate
import com.woodworkersfriend.presentation.ui.icons.Measuring_tape
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase01
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase03
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase1
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase3
import com.woodworkersfriend.presentation.ui.theme.setCardColors
import com.woodworkersfriend.presentation.ui.theme.setThemeColor
import com.woodworkersfriend.presentation.ui.theme.setTopAppBarColors
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.hilt.hiltViewModel
import dev.olshevski.navigation.reimagined.navigate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FunctionsListScreen(
    navController: NavController<Screen>,
    viewModel: FunctionsListViewModel = hiltViewModel()
) {

    Scaffold(
        modifier = Modifier,
        containerColor = setThemeColor(SolarizedBase3, SolarizedBase03),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) { Text(text = stringResource(R.string.functions_list)) }
                },
                actions = {
//                    Row(modifier = Modifier.padding(end = 16.dp)) {
//                        if (delete.value) {
//                            IconButton(
//                                enabled = acceptRemoveEnabled.value,
//                                onClick = {
//                                    showConfirmationDialog.value = true
//                                }) {
//                                Icon(
//                                    imageVector = Check,
//                                    contentDescription = "Localized description"
//                                )
//                            }
//                            IconButton(onClick = {
//                                clearSelected.value = true
//                            }) {
//                                Icon(
//                                    imageVector = Cancel,
//                                    contentDescription = "Localized description"
//                                )
//                            }
//                        } else {
//                            IconButton(onClick = { showAddPortfolioCard.value = true }) {
//                                Icon(
//                                    imageVector = Add,
//                                    contentDescription = "Localized description"
//                                )
//                            }
//                            IconButton(onClick = { delete.value = true }) {
//                                Icon(
//                                    imageVector = Delete,
//                                    contentDescription = "Localized description"
//                                )
//                            }
//                        }
//                    }
                },
                colors = setTopAppBarColors()
                //scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->

        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(DEFAULT_VERTICAL_PADDING),
            modifier = Modifier.padding(vertical = DEFAULT_HORIZONTAL_PADDING),
            content = {
                item() {
                    UnitConversionCard(navController)
                }

                item() {
                    BoardFootCalculator(navController)
                }
            },
        )
    }
}


@Composable
fun BoardFootCalculator(navController: NavController<Screen>) {
    val goToBoardFootCalculator: () -> Unit = {
        navController.navigate(Screen.BoardFootCalculator)
    }

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        colors = setCardColors(),
        onClick = {
            goToBoardFootCalculator()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    /* do something */
                }) {
                Icon(
                    painter = rememberVectorPainter(Calculate),
                    contentDescription = "Return to previous screen",
                    tint = setThemeColor(SolarizedBase01, SolarizedBase1)
                )
            }
            Text(
                text = "Board Foot Calculator",
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}


@Composable
fun UnitConversionCard(navController: NavController<Screen>) {
    val goToUnitConversion: () -> Unit = {
        navController.navigate(Screen.UnitConversion)
    }


    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        colors = setCardColors(),
        onClick = {
            goToUnitConversion()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    /* do something */
                }) {
                Icon(
                    painter = rememberVectorPainter(Measuring_tape),
                    contentDescription = "Return to previous screen",
                    tint = setThemeColor(SolarizedBase01, SolarizedBase1)
                )
            }
            Text(
                text = "Unit Conversion",
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}