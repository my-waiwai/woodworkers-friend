package com.woodworkersfriend.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


// Solarized color palette
val SolarizedBase3 = Color(0xFFFDF6E3)
val SolarizedBase2 = Color(0xFFEEE8D5)
val SolarizedBase1 = Color(0xFF93A1A1)
val SolarizedBase0 = Color(0xFF839496)
val SolarizedBase00 = Color(0xFF657B83)
val SolarizedBase01 = Color(0xFF586E75)
val SolarizedBase02 = Color(0xFF073642)
val SolarizedBase03 = Color(0xFF002b36)
val SolarizedYellow = Color(0xFFB58900)
val SolarizedOrange = Color(0xFFcb4b16)
val SolarizedRed = Color(0xFFdc322f)
val SolarizedMagenta = Color(0xFFd33682)
val SolarizedViolet = Color(0xFF6c71c4)
val SolarizedBlue = Color(0xFF268bd2)
val SolarizedCyan = Color(0xFF2aa198)
val SolarizedGreen = Color(0xFF859900)

val SolarizedBase0_20 = Color(0x33839496)

const val SolarizedGreenInt = 0xFF859900.toInt()
const val SolarizedYellowInt = 0xFFB58900.toInt()
const val SolarizedRedInt = 0xFFdc322f.toInt()


//
// TopAppBar
//

@OptIn(ExperimentalMaterial3Api::class)
val darkTopAppBarColors = TopAppBarColors(
    containerColor = SolarizedBase02,
    scrolledContainerColor = SolarizedBase02,
    navigationIconContentColor = SolarizedBase1,
    titleContentColor = SolarizedBase1,
    actionIconContentColor = SolarizedBase1,
)

@OptIn(ExperimentalMaterial3Api::class)
val lightTopAppBarColors = TopAppBarColors(
    containerColor = SolarizedBase2,
    scrolledContainerColor = SolarizedBase2,
    navigationIconContentColor = SolarizedBase01,
    titleContentColor = SolarizedBase01,
    actionIconContentColor = SolarizedBase01,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun setTopAppBarColors(): TopAppBarColors {
    return when (isSystemInDarkTheme()) {
        true -> darkTopAppBarColors
        false -> lightTopAppBarColors
    }
}


//
// NavigationBar
//

@Composable
fun setNavigationBarContainerColors(): Color {
    return when (isSystemInDarkTheme()) {
        true -> SolarizedBase02
        false -> SolarizedBase2
    }
}

@Composable
fun setNavigationBarContentColors(): Color {
    return when (isSystemInDarkTheme()) {
        true -> SolarizedBase1
        false -> SolarizedBase01
    }
}

@Composable
fun setNavigationBarItemColors(): NavigationBarItemColors {
    return NavigationBarItemDefaults.colors(
        selectedIconColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase1
            false -> SolarizedBase01
        },
        indicatorColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase03
            false -> SolarizedBase3
        }
    )
}


//
// Card
//

val darkCardColors = CardColors(
    containerColor = SolarizedBase02,
    contentColor = SolarizedBase1,
    disabledContainerColor = SolarizedBase03,
    disabledContentColor = SolarizedBase01
)

val lightCardColors = CardColors(
    containerColor = SolarizedBase2,
    contentColor = SolarizedBase01,
    disabledContainerColor = SolarizedBase3,
    disabledContentColor = SolarizedBase1
)

@Composable
fun setCardColors(): CardColors {
    return when (isSystemInDarkTheme()) {
        true -> darkCardColors
        false -> lightCardColors
    }
}


//
// TextField
//

@Composable
fun setTextFieldColors(): TextFieldColors {
    return TextFieldDefaults.colors(
        focusedTextColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase1
            false -> SolarizedBase01
        },
        unfocusedTextColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase1
            false -> SolarizedBase01
        },
        focusedContainerColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase02
            false -> SolarizedBase2
        },
        unfocusedContainerColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase02
            false -> SolarizedBase2
        },
        disabledContainerColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase02
            false -> SolarizedBase2
        },
        focusedPlaceholderColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase01
            false -> SolarizedBase1
        },
        unfocusedPlaceholderColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase01
            false -> SolarizedBase1
        },
        focusedLabelColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase01
            false -> SolarizedBase1
        },
        unfocusedLabelColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase01
            false -> SolarizedBase1
        },
        cursorColor = when (isSystemInDarkTheme()) {
            true -> SolarizedBase01
            false -> SolarizedBase1
        },
        focusedIndicatorColor = when(isSystemInDarkTheme()) {
            true -> SolarizedBase01
            false -> SolarizedBase1
        },
        unfocusedIndicatorColor = when(isSystemInDarkTheme()) {
            true -> SolarizedBase01
            false -> SolarizedBase1
        }
    )
}


//
// Radio Buttons
//

@Composable
fun setRadioButtonColors(): RadioButtonColors {
    return when (isSystemInDarkTheme()) {
        true -> RadioButtonColors(
            selectedColor = SolarizedCyan,
            unselectedColor = SolarizedBase01,
            disabledSelectedColor = SolarizedBase1,
            disabledUnselectedColor = SolarizedBase01,
        )

        false -> RadioButtonColors(
            selectedColor = SolarizedViolet,
            unselectedColor = SolarizedBase1,
            disabledSelectedColor = SolarizedBase01,
            disabledUnselectedColor = SolarizedBase01,
        )
    }
}


@Composable
fun setThemeColor(lightColor: Color, darkColor: Color): Color {
    return when(isSystemInDarkTheme()) {
        true -> darkColor
        false -> lightColor
    }
}
