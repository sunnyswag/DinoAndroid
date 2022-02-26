package com.demo.dinoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.dinoandroid.R
import com.demo.dinoandroid.domain.ReferenceData

class ReferencesListAdapter(private val dataSet: List<ReferenceData>) :
    RecyclerView.Adapter<ReferencesListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val authorIcon: ImageView
        val repositoryName: TextView

        init {
            authorIcon = view.findViewById(R.id.authorIcon)
            repositoryName = view.findViewById(R.id.repositoryName)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.references_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.repositoryName.text = dataSet[position].repositoryName
        holder.authorIcon.setImageResource(R.drawable.dino_stationary)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}