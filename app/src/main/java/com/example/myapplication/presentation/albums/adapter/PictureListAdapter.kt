package com.example.myapplication.presentation.albums.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.remote.models.Products
import com.example.myapplication.domain.entity.ProductsEntity
import kotlinx.android.synthetic.main.item_picture.view.*

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
class PictureListAdapter(val list: List<ProductsEntity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        return PictureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PictureViewHolder).bind(list.get(position))
    }

    inner class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photo = itemView.photo
        private val photoTitle = itemView.photoTitle
        fun bind(item: ProductsEntity) {
            photoTitle.text = item.productInfo?.title
            Glide.with(itemView.context)
                .load(item.productInfo?.imageUrls?.smallPhoto)
                .thumbnail(Glide.with(itemView.context).load(item.productInfo?.imageUrls?.thumbnailPhoto))
                .placeholder(R.drawable.ic_place_holder)
                .error(R.drawable.ic_place_holder)
                .into(photo)
        }
    }
}