package com.brjewels.admin.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.brjewels.admin.android.R
import com.brjewels.admin.android.models.CategoriesListModel

class CategoriesListAdapter(private val categoriesList: List<CategoriesListModel>) :
    RecyclerView.Adapter<CategoriesListAdapter.CategoriesListViewHolder>() {
    private var categoriesItemList = ArrayList<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_list_item, parent, false)
        return CategoriesListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoriesListViewHolder, position: Int) {

        val model = categoriesList[position]
        holder.itemNames.text = model.itemText

        val isExpandable = model.isExpandable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        if (isExpandable) {
            holder.arrowButton.setImageResource(R.drawable.upward_ic)
        } else {
            holder.arrowButton.setImageResource(R.mipmap.down_arrow_ic)
        }

        val adapter = CategoriesNestedAdapter(categoriesItemList)
        holder.nestedRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.nestedRecyclerView.setHasFixedSize(true)
        holder.nestedRecyclerView.adapter = adapter

        holder.expandableLayoutBtnView.setOnClickListener {
            model.setExpandableValue(!model.isExpandable)
            categoriesItemList = model.nestedList as ArrayList<String>
            notifyItemChanged(holder.adapterPosition)
        }


    }

    inner class CategoriesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var expandableLayoutBtnView: LinearLayout =
            itemView.findViewById(R.id.expandable_layout_btn_view)
        var expandableLayout: RelativeLayout = itemView.findViewById(R.id.expandable_layout)
        var itemNames: TextView = itemView.findViewById(R.id.categories_list_names)
        var arrowButton: ImageView = itemView.findViewById(R.id.categories_list_btn)
        var nestedRecyclerView: RecyclerView = itemView.findViewById(R.id.child_rv)

    }
}