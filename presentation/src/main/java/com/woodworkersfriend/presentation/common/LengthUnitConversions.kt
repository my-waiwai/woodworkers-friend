package com.woodworkersfriend.presentation.common

import com.toxicbakery.logging.Arbor
import com.woodworkersfriend.presentation.ConvertFromTo
import java.math.RoundingMode
import kotlin.math.round

fun convertLength(value: String,
                  convertFrom: ConvertFromTo,
                  convertTo: ConvertFromTo,
                  decimalPlaces: Int,
): String {
    if (value.isEmpty()) {
        return ""
    }

    when (convertFrom) {
        ConvertFromTo.Millimeters ->
            return when (convertTo) {
                ConvertFromTo.Millimeters -> value
                ConvertFromTo.Centimeters -> (value.toDouble() / 10).toString()
                ConvertFromTo.Meters -> (value.toDouble() / 1000).toString()
                ConvertFromTo.Inches -> (value.toDouble() / 25.4).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Feet -> (value.toDouble() / 25.4 * 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.FeetIn -> convertToFeetAndInches(value, convertFrom)
                ConvertFromTo.FractionalIn -> getFraction(value.toDouble() / 25.4).toString()
            }
        ConvertFromTo.Centimeters -> {
            return when (convertTo) {
                ConvertFromTo.Millimeters -> (value.toDouble() * 10).toString()
                ConvertFromTo.Centimeters -> value
                ConvertFromTo.Meters -> (value.toDouble() / 100).toString()
                ConvertFromTo.Inches -> (value.toDouble() / 2.54).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Feet -> (value.toDouble() / 2.54 * 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.FeetIn -> convertToFeetAndInches(value, convertFrom)
                ConvertFromTo.FractionalIn -> getFraction(value.toDouble() / 2.54).toString()
            }
        }
        ConvertFromTo.Meters -> {
            return when (convertTo) {
                ConvertFromTo.Millimeters -> (value.toDouble() * 1000).toString()
                ConvertFromTo.Centimeters -> (value.toDouble() * 100).toString()
                ConvertFromTo.Meters -> value
                ConvertFromTo.Inches -> (value.toDouble() / .0254).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Feet -> (value.toDouble() / .0254 * 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.FeetIn -> convertToFeetAndInches(value, convertFrom)
                ConvertFromTo.FractionalIn -> getFraction(value.toDouble() / .0254).toString()
            }
        }
        ConvertFromTo.Inches -> {
            return when (convertTo) {
                ConvertFromTo.Millimeters -> (value.toDouble() * 25.4).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Centimeters -> (value.toDouble() * 2.54).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Meters -> (value.toDouble() * 0.254).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Inches -> value
                ConvertFromTo.Feet -> (value.toDouble() / 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.FeetIn -> convertToFeetAndInches(value, convertFrom)
                ConvertFromTo.FractionalIn -> getFraction(value.toDouble()).toString()
            }
        }
        ConvertFromTo.Feet -> {
            return when (convertTo) {
                ConvertFromTo.Millimeters -> (value.toDouble() * 25.4 * 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Centimeters -> (value.toDouble() * 2.54 * 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Meters -> (value.toDouble() * 0.254 * 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Inches -> (value.toDouble() * 12).toBigDecimal().setScale(decimalPlaces, RoundingMode.HALF_EVEN).toString()
                ConvertFromTo.Feet -> value
                ConvertFromTo.FeetIn -> convertToFeetAndInches(value, convertFrom)
                ConvertFromTo.FractionalIn -> getFraction(value.toDouble() * 12).toString()
            }
        }
        ConvertFromTo.FeetIn -> {
            return ""
        }
        ConvertFromTo.FractionalIn -> {
            return ""
        }
    }
}


fun convertToFeetAndInches(value: String, convertFrom: ConvertFromTo): String {
    if (value.isEmpty()) {
        return ""
    }

    if (convertFrom == ConvertFromTo.Millimeters) {
        val inchesFromMm = value.toDouble() / 25.4
        val inches = (inchesFromMm % 12).toLong()
        val feet = (inchesFromMm / 12).toLong()
        return "$feet ft, $inches in"
    } else if (convertFrom == ConvertFromTo.Centimeters) {
        val inchesFromMm = value.toDouble() / 2.54
        val inches = (inchesFromMm % 12).toLong()
        val feet = (inchesFromMm / 12).toLong()
        return "$feet ft, $inches in"
    } else if (convertFrom == ConvertFromTo.Meters) {
        val inchesFromMm = value.toDouble() / .0254
        val inches = (inchesFromMm % 12).toLong()
        val feet = (inchesFromMm / 12).toLong()
        return "$feet ft, $inches in"
    } else if (convertFrom == ConvertFromTo.Inches) {
        val inches = value.toDouble() % 12
        val feet = (value.toDouble() / 12).toLong()
        return "$feet ft, $inches in"
    } else if (convertFrom == ConvertFromTo.Feet) {
        val tempValue = value.toDouble() * 12
        val inches = tempValue % 12
        val feet = (tempValue / 12).toLong()
        return "$feet ft, $inches in"
    }

    return ""
}


fun getFraction(value: Double): String {
    var denominator = 32
    Arbor.i("value: $value")
    val numerator = round(value * denominator).toInt()
    var wholeInches: Int = 0

    if (numerator > denominator) {
        // calculate the whole number of inches
        wholeInches = (numerator / denominator).toInt()
    }

    // reduce the fraction to lowest denominator
    var screenPrecision = 32
    var screenNumerator = numerator
    while (screenNumerator > 0 && screenNumerator % 2 == 0) {
        Arbor.d("screenNumerator/screenPrecision: $screenNumerator/$screenPrecision")
        screenNumerator /= 2
        screenPrecision /= 2
    }
    Arbor.d("final screenNumerator/screenPrecision: $screenNumerator/$screenPrecision")
    if (screenPrecision == 0) {
        // this means the input is evenly divisible by the precision
        // and is therefore a whole number only
        return "$wholeInches in"
    }
    screenNumerator = screenNumerator % screenPrecision

    val screenInches = screenNumerator / 12


    return if (wholeInches > 0) {
        "$wholeInches $screenNumerator/$screenPrecision in"
    } else {
        "$screenNumerator/$screenPrecision in"
    }
}
