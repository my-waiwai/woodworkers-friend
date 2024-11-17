package com.woodworkersfriend.presentation.ui.unitconversion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.woodworkersfriend.presentation.ConvertFromTo
import com.woodworkersfriend.presentation.R
import com.woodworkersfriend.presentation.common.ConversionType
import com.woodworkersfriend.presentation.common.DEFAULT_HORIZONTAL_PADDING
import com.woodworkersfriend.presentation.common.DEFAULT_TEXT_HORIZONTAL_PADDING
import com.woodworkersfriend.presentation.common.DEFAULT_VERTICAL_PADDING
import com.woodworkersfriend.presentation.common.RadioButtonListItem
import com.woodworkersfriend.presentation.models.Screen
import com.woodworkersfriend.presentation.ui.icons.Arrow_back
import com.woodworkersfriend.presentation.ui.icons.Arrow_drop_down
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase01
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase03
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase1
import com.woodworkersfriend.presentation.ui.theme.SolarizedBase3
import com.woodworkersfriend.presentation.ui.theme.setCardColors
import com.woodworkersfriend.presentation.ui.theme.setTextFieldColors
import com.woodworkersfriend.presentation.ui.theme.setThemeColor
import com.woodworkersfriend.presentation.ui.theme.setTopAppBarColors
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.hilt.hiltViewModel
import dev.olshevski.navigation.reimagined.pop
import java.util.stream.Collectors.toList
import kotlin.math.floor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConversionScreen(
    navController: NavController<Screen>,
    viewModel: UnitConversionViewModel = hiltViewModel()
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
                    ) { Text(text = stringResource(R.string.unit_conversion)) }
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
                    UnitConversionTypeCard(viewModel)
                }

                item() {
                    UnitConversionValue(viewModel)
                }

                item() {
                    when (viewModel.state.conversionType) {
                        ConversionType.Length -> UnitConversionLength(viewModel)
                        ConversionType.Volume -> UnitConversionVolume(viewModel)
                    }
                }
            },
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConversionTypeCard(viewModel: UnitConversionViewModel) {

    var showConversionTypeList = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING)
            .wrapContentHeight(),
        onClick = { showConversionTypeList.value = !showConversionTypeList.value },
        colors = setCardColors(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DEFAULT_TEXT_HORIZONTAL_PADDING),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
                Text(
                    text = "Conversion Type: ${viewModel.state.conversionType.name}",
//                    color = setTextColor(true)
                )
            }
            Column(
                modifier = Modifier.weight(0.5f),
                horizontalAlignment = Alignment.End,
            ) {
                IconButton(onClick = {
                    showConversionTypeList.value = !showConversionTypeList.value
                }) {
                    Icon(
                        painter = rememberVectorPainter(Arrow_drop_down),
                        contentDescription = "Show conversion types",
                        modifier = Modifier.padding(start = 12.dp),
                        tint = setThemeColor(SolarizedBase01, SolarizedBase1)
                    )
                }
            }
        }
        if (showConversionTypeList.value) {
            val radioOptions = ConversionType.entries.map { it.name }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DEFAULT_HORIZONTAL_PADDING)
            ) {
                radioOptions.forEach { option ->
                    RadioButtonListItem(
                        label = option,
                        onClick = {
                            viewModel.onUnitConversionTypeChange(ConversionType.valueOf(option))
                            showConversionTypeList.value = false
                        },
                        viewModel = viewModel,
                    )
                }
            }
        }
    }

}


@Composable
fun UnitConversionValue(viewModel: UnitConversionViewModel) {
    val isDropdownExpanded = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        colors = setCardColors(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = DEFAULT_HORIZONTAL_PADDING,
                    vertical = DEFAULT_VERTICAL_PADDING
                )
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                TextField(
                    value = viewModel.state.valueToConvert,
                    onValueChange = {
                        viewModel.onValueToConvertChange(it)
                    },
                    label = { Text(text = "Value to Convert") },
                    colors = setTextFieldColors(),
                )
            }
            Column(
                modifier = Modifier.weight(0.5f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = viewModel.state.convertFrom.abbreviation)
                    IconButton(onClick = {
                        isDropdownExpanded.value = !isDropdownExpanded.value
                    }) {
                        Icon(
                            painter = rememberVectorPainter(Arrow_drop_down),
                            contentDescription = "Show conversion from options",
                            modifier = Modifier.padding(start = 12.dp),
                            tint = setThemeColor(SolarizedBase01, SolarizedBase1)
                        )
                    }
                }
                DropdownMenu(
                    expanded = isDropdownExpanded.value,
                    containerColor = setThemeColor(SolarizedBase3, SolarizedBase03),
                    onDismissRequest = {
                        isDropdownExpanded.value = false
                    }) {
                    ConvertFromTo.entries.forEach { unit ->
                        DropdownMenuItem(
                            text = {
                                Text(text = unit.abbreviation)
                            },
                            onClick = {
                                isDropdownExpanded.value = !isDropdownExpanded.value
                                viewModel.onDropdownMenuClick(unit)
                            }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun UnitConversionLength(viewModel: UnitConversionViewModel) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        colors = setCardColors(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            UnitConversionLengthListItem(viewModel, ConvertFromTo.Millimeters, true)
            UnitConversionLengthListItem(viewModel, ConvertFromTo.Centimeters, true)
            UnitConversionLengthListItem(viewModel, ConvertFromTo.Meters, true)
            UnitConversionLengthListItem(viewModel, ConvertFromTo.Inches, true)
            UnitConversionLengthListItem(viewModel, ConvertFromTo.Feet, true)
            UnitConversionLengthListItem(viewModel, ConvertFromTo.FeetIn, true)
            UnitConversionLengthListItem(viewModel, ConvertFromTo.FractionalIn, false)
        }
    }
}


@Composable
fun UnitConversionLengthListItem(
    viewModel: UnitConversionViewModel,
    convertTo: ConvertFromTo,
    showDivider: Boolean = true,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = DEFAULT_TEXT_HORIZONTAL_PADDING,
                vertical = DEFAULT_HORIZONTAL_PADDING
            ),
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = convertTo.abbreviation,
        )
        Text(
            modifier = Modifier.weight(1f),
            text = when (viewModel.state.valueToConvert.isNotEmpty()) {
                true -> {
                    if (convertTo == ConvertFromTo.Millimeters) {
                        viewModel.state.convertedValueState.millimeters
                    } else if (convertTo == ConvertFromTo.Centimeters) {
                        viewModel.state.convertedValueState.centimeters
                    } else if (convertTo == ConvertFromTo.Meters) {
                        viewModel.state.convertedValueState.meters
                    } else if (convertTo == ConvertFromTo.Inches) {
                        viewModel.state.convertedValueState.inches
                    } else if (convertTo == ConvertFromTo.Feet) {
                        viewModel.state.convertedValueState.feet
                    } else if (convertTo == ConvertFromTo.FeetIn) {
                        viewModel.state.convertedValueState.feetIn
                    } else if (convertTo == ConvertFromTo.FractionalIn) {
                        viewModel.state.convertedValueState.fractionalIn
                    } else {
                        ""
                    }
                }
                false -> ""
            },
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
        )
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showDivider) {
            HorizontalDivider(
                modifier = Modifier
                    .padding(horizontal = DEFAULT_HORIZONTAL_PADDING)
                    .alpha(.2f),
            )
        }

    }
}


@Composable
fun UnitConversionVolume(viewModel: UnitConversionViewModel) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        colors = setCardColors(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Volume")
        }
    }
}