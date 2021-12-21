package com.dorrrke.finanseproject.data.db.dao

import androidx.room.*
import com.dorrrke.finanseproject.data.dbModels.PlanTableModel
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PlanTableDao {
    @Query("SELECT * FROM planTable")
    fun getAll(): Flowable<List<PlanTableModel>>

    @Query("SELECT * FROM planTable WHERE pId IN (:planId)")
    fun loadAllByIds(planId: Int): Flowable<List<PlanTableModel>>

//    @Query(
//        "SELECT * FROM plan_table WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1"
//    )
//    fun findByName(first: String, last: String): PlanTableModel

    @Update
    fun update(user: PlanTableModel) : Completable

    @Insert
    fun insertAll(vararg userModels: PlanTableModel) : Completable

    @Delete
    fun delete(userModel: PlanTableModel) : Completable





}