package com.dorrrke.finanseproject.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dorrrke.finanseproject.R
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import com.dorrrke.finanseproject.data.dbModels.PlanTableModel
import com.dorrrke.finanseproject.data.models.PlanTable
import com.dorrrke.finanseproject.presentation.viewmodels.EditViewModel
import com.dorrrke.finanseproject.presentation.viewmodels.MainViewModel
import com.dorrrke.finanseproject.presentation.viewmodels.factories.EditViewModelFactory
import com.dorrrke.finanseproject.presentation.viewmodels.factories.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.fragment_edit.view.*


class EditFragment(private val plan: PlanModel, private val remains: Double) : Fragment() {
    private lateinit var vm2: EditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vm2 = ViewModelProvider(this, EditViewModelFactory(inflater.context)).get(EditViewModel::class.java)
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(plan: PlanModel, remains: Double) = EditFragment(plan, remains)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var addBtn = view.findViewById<Button>(R.id.add_btn)
        addBtn.setOnClickListener{
            var purchase = view.findViewById<EditText>(R.id.addPurchase_et)
            var type = view.findViewById<EditText>(R.id.addType_et)
            var price = view.findViewById<EditText>(R.id.addPrice_et)
            val planTable = PlanTableModel(0, purchase.text.toString(), type.text.toString(), price.text.toString().toInt(), plan.pid)
            if (planTable.price > remains)
            {
                Toast.makeText(context, "You can't afford it! You have a $remains", Toast.LENGTH_SHORT).show()
            }
            else{
                vm2.addPurchase(planTable)
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.place_holder, TableFragment(plan))?.commit()
            }
        }

    }

}