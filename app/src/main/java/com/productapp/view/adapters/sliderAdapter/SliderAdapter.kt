package com.productapp.view.adapters.sliderAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.productapp.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(imageUrl: List<String>) : SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    private var sliderImage: List<String> = imageUrl

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        var inflater: View = LayoutInflater.from(parent!!.context).inflate(R.layout.slideritem, null)
        return SliderViewHolder(inflater)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        if (viewHolder != null) {
            Glide.with(viewHolder.imageView)
                .load(sliderImage.get(position))
                .fitCenter()
                .into(viewHolder.imageView)
        }
    }

    override fun getCount(): Int {
        return sliderImage.size
    }

    inner class SliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imagesProduct)
    }
}