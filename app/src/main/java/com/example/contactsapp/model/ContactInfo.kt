package com.example.contactsapp.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ContactInfo(
    @StringRes val name: Int,
    @StringRes val number: Int,
    @DrawableRes val picture: Int,
)
