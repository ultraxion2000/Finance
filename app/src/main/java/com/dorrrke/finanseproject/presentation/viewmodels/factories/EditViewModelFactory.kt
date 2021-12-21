package com.dorrrke.finanseproject.presentation.viewmodels.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dorrrke.finanseproject.data.db.AppDatabase
import com.dorrrke.finanseproject.presentation.viewmodels.EditViewModel
import com.dorrrke.finanseproject.presentation.viewmodels.MainViewModel

class EditViewModelFactory(context : Context) : ViewModelProvider.Factory {
    var db: AppDatabase = AppDatabase.getAppDatabase(context)!!
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EditViewModel(db) as T
    }
}