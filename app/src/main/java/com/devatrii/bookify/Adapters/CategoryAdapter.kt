package com.devatrii.bookify.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.devatrii.bookify.DetailsActivity
import com.devatrii.bookify.Models.BooksModel
import com.devatrii.bookify.Utils.loadOnline
import com.devatrii.bookify.databinding.ItemBookGridBinding

class CategoryAdapter(val list: ArrayList<BooksModel>, val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    class CategoryViewHolder(val binding: ItemBookGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: BooksModel, context: Context) {
            binding.apply {
                imageView.setImageResource(model.image)
                cardView.setOnClickListener {
                    Intent().apply {
                        putExtra("book_title", model.title)
                        putExtra("book_desc", model.description)
                        putExtra("book_pdf", model.bookPDF)
                        putExtra("book_image", model.image)
                        setClass(context, DetailsActivity::class.java)
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            context as Activity,
                            cardView,
                            cardView.transitionName
                        )
                        context.startActivity(this, options.toBundle())
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemBookGridBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(
            model = list[position], context = context
        )
    }
}