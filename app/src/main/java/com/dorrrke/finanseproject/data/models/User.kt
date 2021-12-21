package com.dorrrke.finanseproject.data.models

import androidx.room.ColumnInfo

class User(
    val first_name: String?,
    val last_name: String?,
    val middle_name: String?,
    val phone: String?,
    val email_address: String?
) {
}