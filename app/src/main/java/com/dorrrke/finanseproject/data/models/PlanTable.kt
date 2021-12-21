package com.dorrrke.finanseproject.data.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class PlanTable(
    val purchase: String,
    val type: String,
    val price: Double,
) {
}
