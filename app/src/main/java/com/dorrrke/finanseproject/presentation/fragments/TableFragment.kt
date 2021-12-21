package com.dorrrke.finanseproject.presentation.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.finanseproject.R
import com.dorrrke.finanseproject.data.adapters.TablePlanRecyclerAdapter
import com.dorrrke.finanseproject.data.db.AppDatabase
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import com.dorrrke.finanseproject.data.dbModels.PlanTableModel
import com.dorrrke.finanseproject.presentation.viewmodels.TableViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class TableFragment(plan: PlanModel) : Fragment() {
    private lateinit var vm4: TableViewModel
    private val plan = plan
    private val compositeDisposable = CompositeDisposable()
    lateinit var db: AppDatabase
    lateinit var list: ArrayList<PlanTableModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        db = AppDatabase.getAppDatabase(inflater.context)!!


        return inflater.inflate(R.layout.fragment_table, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(planM: PlanModel) = TableFragment(planM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.budgetInfo).text = plan.budget.toString()
        view.findViewById<TextView>(R.id.periodInfo).text = plan.period


        var recycler: RecyclerView = view.findViewById(R.id.tableRecycler)
        recycler.layoutManager = LinearLayoutManager(context)

        compositeDisposable.add(db.planTable().loadAllByIds(plan.pid)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.e(ContentValues.TAG, "downloading table data = ${it.size}")
                recycler.adapter = TablePlanRecyclerAdapter(it)
                var spentSum = 0
                for (i in it) {
                    spentSum += i.price
                }
                var remains = plan.budget - spentSum
                view.findViewById<TextView>(R.id.spentInfo).text = spentSum.toString()
                view.findViewById<TextView>(R.id.remainsInfo).text = remains.toString()
            })


        var createBtn = view.findViewById<Button>(R.id.addBuyBtn)
        createBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(
                    R.id.place_holder,
                    EditFragment(
                        plan,
                        view.findViewById<TextView>(R.id.remainsInfo).text.toString().toDouble()
                    )
                )?.commit()
        }

    }


}

