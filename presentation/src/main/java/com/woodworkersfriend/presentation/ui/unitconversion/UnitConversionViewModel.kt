package com.woodworkersfriend.presentation.ui.unitconversion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toxicbakery.logging.Arbor
import com.woodworkersfriend.presentation.ConvertFromTo
import com.woodworkersfriend.presentation.common.ConversionType
import com.woodworkersfriend.presentation.common.convertLength
import com.woodworkersfriend.presentation.models.ConvertedValueState
import com.woodworkersfriend.presentation.models.UnitConversionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnitConversionViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(
        UnitConversionUiState()
    )
        private set

    fun init() {
        viewModelScope.launch {

        }
    }

    fun onUnitConversionTypeChange(conversionType: ConversionType) {
        state = state.copy(conversionType = conversionType)
    }

    fun onDropdownMenuClick(unit: ConvertFromTo) {
        state = state.copy(convertFrom = unit)
    }

    fun onValueToConvertChange(value: String) {
        state = state.copy(valueToConvert = value)
        Arbor.i("value: $value")

        // TODO: call the conversion function here
        if (value.endsWith('.'))
            return

        Arbor.i("value: $value")
        state.convertedValueState.millimeters = convertLength(value, state.convertFrom, ConvertFromTo.Millimeters, state.decimalPlaces)
        state.convertedValueState.centimeters = convertLength(value, state.convertFrom, ConvertFromTo.Centimeters, state.decimalPlaces)
        state.convertedValueState.meters = convertLength(value, state.convertFrom, ConvertFromTo.Meters, state.decimalPlaces)
        state.convertedValueState.inches = convertLength(value, state.convertFrom, ConvertFromTo.Inches, state.decimalPlaces)
        state.convertedValueState.feet = convertLength(value, state.convertFrom, ConvertFromTo.Feet, state.decimalPlaces)
        state.convertedValueState.feetIn = convertLength(value, state.convertFrom, ConvertFromTo.FeetIn, state.decimalPlaces)
        state.convertedValueState.fractionalIn = convertLength(value, state.convertFrom, ConvertFromTo.FractionalIn, state.decimalPlaces)
    }
}