package com.woodworkersfriend.presentation.ui.jankahardness

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.woodworkersfriend.presentation.R
import com.woodworkersfriend.presentation.common.DEFAULT_HORIZONTAL_PADDING
import com.woodworkersfriend.presentation.common.DEFAULT_VERTICAL_PADDING
import com.woodworkersfriend.presentation.models.Screen
import com.woodworkersfriend.presentation.ui.icons.Arrow_back
import com.woodworkersfriend.presentation.ui.icons.Info
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
import dev.olshevski.navigation.reimagined.pop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JankaHardnessScreen(
    navController: NavController<Screen>,
    viewModel: JankaHardnessViewModel = hiltViewModel()
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
                    ) { Text(text = stringResource(R.string.janka_hardness)) }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.pop()
                    }) {
                        Icon(
                            painter = rememberVectorPainter(Arrow_back),
                            contentDescription = "Return to previous screen",
                            modifier = Modifier.padding(start = 12.dp),
                            tint = setThemeColor(SolarizedBase01, SolarizedBase1)
                        )
                    }
                },
                actions = {
                    Row(modifier = Modifier.padding(end = 16.dp)) {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Info,
                                contentDescription = "Localized description"
                            )
                        }
                    }
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
                    UnitConversionCard()
                }

                item() {
                    BoardFootCalculator()
                }
            },
        )
    }

}

@Composable
fun BoardFootCalculator() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        colors = setCardColors(),
        onClick = {
//                            goToPortfolioDetail(
//                                with(portfolio) {
//                                    PortfolioDetailUiItem(
//                                        id = id,
//                                        name = name,
//                                        selectedForDeletion = false,
//                                    )
//                                }
//                            )
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
                text = "Board Foot Calculator",
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

@Composable
fun UnitConversionCard() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        colors = setCardColors(),
        onClick = {
//                            goToPortfolioDetail(
//                                with(portfolio) {
//                                    PortfolioDetailUiItem(
//                                        id = id,
//                                        name = name,
//                                        selectedForDeletion = false,
//                                    )
//                                }
//                            )
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