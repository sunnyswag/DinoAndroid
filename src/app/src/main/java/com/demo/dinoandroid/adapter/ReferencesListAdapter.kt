package com.demo.dinoandroid.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.dinoandroid.R
import com.demo.dinoandroid.domain.ReferenceData
import com.demo.dinoandroid.viewmodel.ReferencesViewModel

class ReferencesListAdapter(private val dataSet: List<ReferenceData>,
                            private val viewModel: ReferencesViewModel) :
    RecyclerView.Adapter<ReferencesListAdapter.ViewHolder>() {

    class ViewHolder(
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.references_list_item, parent, false)
    ) {
        private val authorIcon: ImageView = itemView.findViewById(R.id.authorIcon)
        private val repositoryName: TextView = itemView.findViewById(R.id.repositoryName)
        var repositoryUrl: String? = null

        fun bindData(data: ReferenceData) {
            repositoryName.text = data.repositoryName
            authorIcon.setImageResource(R.drawable.dino_stationary)
            repositoryUrl = data.repositoryUrl
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(parent).apply { itemView.setOnClickListener{
            itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(repositoryUrl)))
            viewModel.referenceListDisplay.value = false
        } }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}