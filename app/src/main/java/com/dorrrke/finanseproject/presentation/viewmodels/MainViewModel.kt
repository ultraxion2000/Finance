package com.dorrrke.finanseproject.presentation.viewmodels

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.dorrrke.finanseproject.data.db.AppDatabase
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val db : AppDatabase) : ViewModel(){

    init {

    }

    @SuppressLint("CheckResult")
    fun downloadPlans(): List<PlanModel> {
        var aList = ArrayList<PlanModel>()
        db.plans().getAll().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.e(TAG, "downloading data")
                Log.e(TAG, "download = ${it.size}")
                aList = it as ArrayList<PlanModel>
            }
        return aList
    }



}