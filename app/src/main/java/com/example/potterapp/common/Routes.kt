package com.example.potterapp.common

import androidx.annotation.StringRes
import com.example.potterapp.R

public enum class ScreenRoutes(@StringRes val title: Int){
    Start(title = R.string.app_name),
    Detail(title = R.string.detailed_sceen)
}