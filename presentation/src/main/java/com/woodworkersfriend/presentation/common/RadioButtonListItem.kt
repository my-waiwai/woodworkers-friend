package com.woodworkersfriend.presentation.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.woodworkersfriend.presentation.ui.theme.setRadioButtonColors
import com.woodworkersfriend.presentation.ui.unitconversion.UnitConversionViewModel

@Composable
fun RadioButtonListItem(label: String, onClick: () -> Unit, viewModel: UnitConversionViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = DEFAULT_HORIZONTAL_PADDING),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = (label == viewModel.state.conversionType.name),
            onClick = onClick,
            colors = setRadioButtonColors(),
        )
        Text(text = label)
    }
}
