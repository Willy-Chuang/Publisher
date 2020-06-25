package com.willy.publisher.publisher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.willy.publisher.data.Articles
import com.willy.publisher.databinding.ItemPublisherBinding

class PublisherAdapter : ListAdapter<Articles, PublisherAdapter.PublisherViewHolder>(DiffCallback) {

    class PublisherViewHolder(private var binding: ItemPublisherBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(articles: Articles) {
            articles.let {
                binding.data = articles
                binding.executePendingBindings()
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Articles>() {
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublisherViewHolder {
        return PublisherViewHolder(
            ItemPublisherBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: PublisherViewHolder, position: Int) {

        holder.bind(getItem(position))    }
}