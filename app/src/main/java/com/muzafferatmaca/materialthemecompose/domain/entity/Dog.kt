package com.muzafferatmaca.materialthemecompose.domain.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Muzaffer Atmaca on 5.06.2024 at 17:33
 */
data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)