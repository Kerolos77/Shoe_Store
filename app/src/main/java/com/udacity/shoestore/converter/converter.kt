package com.udacity.shoestore.converter

import androidx.databinding.InverseMethod

object DoubleConverter {

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double?): String {
        return value?.toString() ?: ""
    }

    @JvmStatic
    fun stringToDouble(value: String): Double? {
        return if (value.isNotEmpty()) {
            value.toDouble()
        } else {
            0.0
        }
    }
}