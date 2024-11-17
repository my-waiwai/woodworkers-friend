package com.woodworkersfriend.presentation.common

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.woodworkersfriend.presentation.R
import com.woodworkersfriend.presentation.models.Screen
import com.woodworkersfriend.presentation.ui.icons.Apps
import com.woodworkersfriend.presentation.ui.icons.Calculate
import com.woodworkersfriend.presentation.ui.icons.Keyboard_double_arrow_down
import com.woodworkersfriend.presentation.ui.icons.Measuring_tape

enum class BottomNavigationItem(val route: Screen,
                                val icon: ImageVector,
                                @StringRes val title: Int) {

    FunctionsListItem(
        route = Screen.FunctionsList,
        icon = Apps,
        title = R.string.functions_list
    ),
    UnitConversionItem(
        route = Screen.UnitConversion,
        icon = Measuring_tape,
        title = R.string.unit_conversion
    ),
    BoardFootCalculatorItem(
        route = Screen.BoardFootCalculator,
        icon = Calculate,
        title = R.string.board_foot_calculator
    ),
    JankaHardnessItem(
        route = Screen.JankaHardness,
        icon = Keyboard_double_arrow_down,
        title = R.string.janka_hardness
    ),
}


val DEFAULT_HORIZONTAL_PADDING = 8.dp
val DEFAULT_VERTICAL_PADDING = 8.dp
val DEFAULT_TEXT_HORIZONTAL_PADDING = 16.dp


