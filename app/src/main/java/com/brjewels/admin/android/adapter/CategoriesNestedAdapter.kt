package com.brjewels.admin.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brjewels.admin.android.R

class CategoriesNestedAdapter(private val categoriesList : List<String>) : RecyclerView.Adapter<CategoriesNestedAdapter.CategoriesNestedViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesNestedAdapter.CategoriesNestedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_nestedlist_item , parent , false)

        return CategoriesNestedViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CategoriesNestedAdapter.CategoriesNestedViewHolder,
        position: Int
    ) {
        holder.nestedItemNames.text = categoriesList[position]
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    inner class CategoriesNestedViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var nestedItemNames : TextView = itemView.findViewById(R.id.categores_nestedlist_txt)

    }
}
