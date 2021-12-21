package com.dorrrke.finanseproject.data.dbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "plans"
)
data class PlanModel(
    @PrimaryKey(autoGenerate = true) val pid: Int,
    @ColumnInfo(name = "period") val period: String,
    @ColumnInfo(name = "budget") val budget: Double,
    @ColumnInfo(name = "moneybox") val moneybox: Boolean,
) {
}