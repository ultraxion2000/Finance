package com.dorrrke.finanseproject.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.dorrrke.finanseproject.R
import com.dorrrke.finanseproject.presentation.viewmodels.CreatePlanViewModel
import com.dorrrke.finanseproject.presentation.viewmodels.factories.CreatePlanViewModelFactory


class CreatePlanFragment : Fragment() {
    private lateinit var vm: CreatePlanViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vm = ViewModelProvider(this, CreatePlanViewModelFactory(inflater.context)).get(CreatePlanViewModel::class.java)
        return inflater.inflate(R.layout.fragment_create_plan, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreatePlanFragment()
    }
 //Сделать обработку на пустые поля!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addBtn = view.findViewById<Button>(R.id.createBtn)
        addBtn.setOnClickListener {
            val budget = view.findViewById<EditText>(R.id.budgetEt)
            val period = view.findViewById<EditText>(R.id.periodEt)
            vm.createPlan(period.text.toString(), budget.text.toString())
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.place_holder, MainFragment())?.commit()
        }
    }
}