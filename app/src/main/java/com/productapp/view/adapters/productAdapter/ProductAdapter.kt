package com.productapp.view.adapters.productAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.productapp.databinding.ProductItemBinding
import com.productapp.service.Model.Products

class ProductAdapter(
    private val con: Context,
    private val product: List<Products> = arrayListOf()
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var onItemClick: ((entity: Products) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)

        return ProductViewHolder(binding)
    }

    override fun getItemCount() = product.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Glide.with(con).load(product[position].thumbnail).into(holder.thumbnail)
        holder.bind(product[position])
    }

    inner class ProductViewHolder(
        private val binding: ProductItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        var thumbnail = binding.ivThumbProduct

        fun bind(product: Products) {
            binding.tvTitle.text = product.title
            binding.tvPrice.text = product.price.toString()
            binding.tvRating.text = product.rating.toString()
            binding.tvCategory.text = product.category
            binding.btnDetailedProduct.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }
    }
}