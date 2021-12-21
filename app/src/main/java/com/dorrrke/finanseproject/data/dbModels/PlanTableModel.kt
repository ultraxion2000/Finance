package com.dorrrke.finanseproject.data.dbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planTable", foreignKeys = [
        androidx.room.ForeignKey(
            entity = PlanModel::class,
            parentColumns = arrayOf("pid"),
            childColumns = arrayOf("pId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        )])
data class PlanTableModel(
    @PrimaryKey(autoGenerate = true) val ptId: Int,
    @ColumnInfo(name = "purchase") val purchase: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "pId") val pId: Int
) {
}