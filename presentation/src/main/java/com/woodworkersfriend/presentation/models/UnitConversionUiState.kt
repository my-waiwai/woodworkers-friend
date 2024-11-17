package com.woodworkersfriend.presentation.models

import com.woodworkersfriend.presentation.ConvertFromTo
import com.woodworkersfriend.presentation.common.ConversionType
import com.woodworkersfriend.presentation.models.ConvertedValueState

data class UnitConversionUiState(
    var conversionType: ConversionType = ConversionType.Length,
    var convertFrom: ConvertFromTo = ConvertFromTo.Millimeters,
    var valueToConvert: String = "",
    var convertedValueState: ConvertedValueState = ConvertedValueState(),
    var decimalPlaces: Int = 8,
    var fractionPrecision: Int = 32,
)

data class ConvertedValueState(
    var millimeters: String = "",
    var centimeters: String = "",
    var meters: String = "",
    var inches: String = "",
    var feet: String = "",
    var feetIn: String = "",
    var fractionalIn: String = "",
)
