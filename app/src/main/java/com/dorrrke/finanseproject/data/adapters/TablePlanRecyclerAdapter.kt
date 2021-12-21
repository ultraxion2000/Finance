package com.dorrrke.finanseproject.data.adapters

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.finanseproject.R
import com.dorrrke.finanseproject.data.dbModels.PlanTableModel

class TablePlanRecyclerAdapter(private val table: List<PlanTableModel>) :
    RecyclerView.Adapter<TablePlanRecyclerAdapter.TableViewHolder>() {

    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var purchaseTextView: TextView? = null
        var typeTextView: TextView? = null
        var priceTextView: TextView? = null

        init {
            purchaseTextView = itemView.findViewById(R.id.purchaseTextView)
            typeTextView = itemView.findViewById(R.id.typeTextView)
            priceTextView = itemView.findViewById(R.id.priceTextView)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view, parent, false)
        return TablePlanRecyclerAdapter.TableViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        Log.e(TAG, "покупка: ${table[position].purchase}, ${table[position].type}, ${table[position].price.toString()}")
        holder.purchaseTextView?.text = table[position].purchase
        holder.typeTextView?.text = table[position].type
        holder.priceTextView?.text = table[position].price.toString()

    }

    override fun getItemCount() = table.size


}