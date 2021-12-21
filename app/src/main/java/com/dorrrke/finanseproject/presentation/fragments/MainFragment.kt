package com.dorrrke.finanseproject.presentation.fragments

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.dorrrke.finanseproject.R
import com.dorrrke.finanseproject.data.adapters.MainPageRecyclerAdapter
import com.dorrrke.finanseproject.data.db.AppDatabase
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import com.dorrrke.finanseproject.presentation.viewmodels.EditViewModel
import com.dorrrke.finanseproject.presentation.viewmodels.MainViewModel
import com.dorrrke.finanseproject.presentation.viewmodels.factories.MainViewModelFactory
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.MaybeEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainFragment : Fragment() {

    private lateinit var vm: MainViewModel
    lateinit var db: AppDatabase
    var list = ArrayList<PlanModel>()
    private val compositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vm = ViewModelProvider(this, MainViewModelFactory(inflater.context)).get(MainViewModel::class.java)

        db = AppDatabase.getAppDatabase(inflater.context)!!

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        loadDb().subscribeOn(Schedulers.newThread())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { Log.e(TAG, "loading data") }
        var fm = activity?.supportFragmentManager

        val recycler: RecyclerView = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(context)


        compositeDisposable.add(db.plans().getAll()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                recycler.adapter = MainPageRecyclerAdapter(it, fm!!)
                Log.e(TAG, "downloading data = ${it.size}")
            })
    }

}


