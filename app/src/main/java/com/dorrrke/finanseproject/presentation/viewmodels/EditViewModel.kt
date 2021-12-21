package com.dorrrke.finanseproject.presentation.viewmodels
import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.dorrrke.finanseproject.data.db.AppDatabase
import com.dorrrke.finanseproject.data.dbModels.PlanTableModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class EditViewModel(private val db : AppDatabase): ViewModel() {

    @SuppressLint("CheckResult")
    fun addPurchase(planTable: PlanTableModel)
    {
        db.planTable().insertAll(planTable).subscribeOn(Schedulers.newThread()).observeOn(
            AndroidSchedulers.mainThread())
            .subscribe { Log.e(ContentValues.TAG, "Add new purchase") }
    }


}