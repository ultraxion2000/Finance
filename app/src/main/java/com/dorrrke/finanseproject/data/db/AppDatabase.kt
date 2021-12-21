package com.dorrrke.finanseproject.data.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dorrrke.finanseproject.data.db.dao.PlanDao
import com.dorrrke.finanseproject.data.db.dao.PlanTableDao
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import com.dorrrke.finanseproject.data.dbModels.PlanTableModel


@Database(entities = [PlanModel::class, PlanTableModel::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun plans():PlanDao
    abstract fun planTable():PlanTableDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "room-kotlin-database"
                ).build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}