package com.dorrrke.finanseproject.presentation.viewmodels

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.dorrrke.finanseproject.data.db.AppDatabase
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CreatePlanViewModel(private val db: AppDatabase) : ViewModel() {

    @SuppressLint("CheckResult")
    fun createPlan(period: String, budget: String) {
        db.plans().insertAll(PlanModel(0, period, budget.toDouble(), false))
            .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribe { Log.e(TAG, "create new plan") }
    }
}