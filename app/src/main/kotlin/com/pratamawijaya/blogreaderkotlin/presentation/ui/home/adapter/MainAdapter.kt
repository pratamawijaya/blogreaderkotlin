package com.pratamawijaya.blogreaderkotlin.presentation.ui.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratamawijaya.blogreaderkotlin.R
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.adapter.MainAdapter.MainHolder
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Created by pratama
 * Date : May - 5/8/17
 * Project Name : BlogReaderKotlin
 */
class MainAdapter(val context: Context, val posts: List<Post>, val listener: MainAdapterListener)
    : RecyclerView.Adapter<MainHolder>() {

    interface MainAdapterListener {
        fun postSelected(post: Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder = MainHolder(
            LayoutInflater.from(context).inflate(R.layout.item_post, parent, false))

    override fun onBindViewHolder(holder: MainHolder, position: Int) = holder.bindItem(
            posts[position], listener)

    override fun getItemCount(): Int = posts.size

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(post: Post, listener: MainAdapterListener) = with(itemView) {
            tvTitle.text = post.title
            tvDate.text = post.getDateFormatted()

            setOnClickListener { listener.postSelected(post) }
        }


    }
}