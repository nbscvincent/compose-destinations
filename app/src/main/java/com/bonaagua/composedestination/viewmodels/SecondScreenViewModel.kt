package com.bonaagua.composedestination.viewmodels

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SecondScreenViewModel : ViewModel() {
    fun getCurrentDay(): String {
        val dateFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        return dateFormat.format(Date())
    }

    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
        return dateFormat.format(Date())
    }

    fun getCurrentTime12Hr(): String {
        val dateFormat = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
        return dateFormat.format(Date())
    }
}
