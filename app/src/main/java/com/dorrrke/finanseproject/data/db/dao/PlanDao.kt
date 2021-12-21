package com.dorrrke.finanseproject.data.db.dao

import androidx.room.*
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PlanDao {

    @Query("SELECT * FROM plans ORDER BY pid DESC")
    fun getAll(): Flowable<List<PlanModel>>

    @Query("SELECT * FROM plans WHERE pid IN (:planIds)")
    fun loadAllByIds(planIds: IntArray): Flowable<List<PlanModel>>


    @Update
    fun update(plan: PlanModel) : Completable

    @Insert
    fun insertAll(vararg planModels: PlanModel) : Completable

    @Delete
    fun delete(planModel: PlanModel) : Completable
}