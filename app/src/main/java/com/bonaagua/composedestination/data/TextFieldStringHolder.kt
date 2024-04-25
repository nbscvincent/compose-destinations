package com.bonaagua.composedestination.data

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object TextFieldStringHolder {
    private val _textFieldData = MutableStateFlow<TextFieldData?>(null)
    val textFieldData = _textFieldData.asStateFlow()

    fun setString(string : TextFieldData) {
        if (TextFieldStringHolder._textFieldData.value != string) {
            TextFieldStringHolder._textFieldData.value = string

            // Log the inserted LoggedInUser
            Log.i("TextFieldStringHolder", "Inserted String: $string")
        }
    }

    fun clearString() {
        TextFieldStringHolder._textFieldData.value = null
        Log.i("TextFieldStringHolder", "Cleared String: ${TextFieldStringHolder._textFieldData.value}")
    }

    fun getString(): TextFieldData? {
        return TextFieldStringHolder._textFieldData.value
    }
}