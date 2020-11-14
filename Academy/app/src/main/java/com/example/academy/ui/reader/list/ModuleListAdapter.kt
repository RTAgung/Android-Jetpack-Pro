package com.example.academy.ui.reader.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.academy.R
import com.example.academy.data.source.local.entity.ModuleEntity

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener) :
    RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>() {
    private val listModules = ArrayList<ModuleEntity>()

    internal fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) return
        listModules.clear()
        listModules.addAll(modules)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_module_list_custom, parent, false)
        return ModuleViewHolder(view)
    }

    override fun getItemCount(): Int = listModules.size

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
        if (holder.itemViewType == 0) {
            holder.textModuleTitle.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.colorTextSecondary
                )
            )
        } else {
            holder.itemView.setOnClickListener {
                listener.onItemClicked(
                    holder.adapterPosition,
                    listModules[holder.adapterPosition].moduleId
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val modulePosition = listModules[position].position
        return when {
            modulePosition == 0 -> 1
            listModules[modulePosition - 1].read -> 1
            else -> 0
        }
    }

    inner class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textModuleTitle = itemView.findViewById<TextView>(R.id.text_module_title)
        private val textTitle: TextView = itemView.findViewById(R.id.text_module_title)
        fun bind(module: ModuleEntity) {
            textTitle.text = module.title
        }
    }
}

internal interface MyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}