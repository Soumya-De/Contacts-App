package com.example.contactsapp

import android.net.Uri

data class ContactItem(
    val name: String,
    val phoneNumber: String,
    val imageRes: Uri
) {
}