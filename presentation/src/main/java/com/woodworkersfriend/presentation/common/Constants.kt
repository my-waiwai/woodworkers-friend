package com.woodworkersfriend.presentation.common

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.woodworkersfriend.presentation.R
import com.woodworkersfriend.presentation.models.Screen
import com.woodworkersfriend.presentation.ui.icons.Apps

enum class BottomNavigationItem(val route: Screen,
                                val icon: ImageVector,
                                @StringRes val title: Int) {

    FunctionsListItem(
        route = Screen.FunctionsList,
        icon = Apps,
        title = R.string.functions_list
    ),
//    SearchItem(
//        route = Screen.Search,
//        icon = Search,
//        title = R.string.search
//    ),
//    HelpItem(
//        route = Screen.Help,
//        icon = Question_mark,
//        title = R.string.help
//    ),
//    SettingsItem(
//        route = Screen.Settings,
//        icon = Settings,
//        title = R.string.settings
//    )

}


val DEFAULT_HORIZONTAL_PADDING = 8.dp
val DEFAULT_VERTICAL_PADDING = 8.dp
val DEFAULT_TEXT_HORIZONTAL_PADDING = 16.dp


