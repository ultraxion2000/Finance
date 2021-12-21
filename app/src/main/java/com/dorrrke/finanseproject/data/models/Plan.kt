package com.dorrrke.finanseproject.data.models

import androidx.room.ColumnInfo

class Plan(
    val period: String,
    val budget: Double,
    val moneybox: Boolean,
    val table: ArrayList<PlanTable>
) {
}