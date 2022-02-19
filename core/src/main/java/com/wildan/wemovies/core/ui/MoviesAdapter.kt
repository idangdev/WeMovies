package com.wildan.wemovies.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildan.wemovies.core.R
import com.wildan.wemovies.core.data.source.remote.network.ApiService
import com.wildan.wemovies.core.databinding.ItemListMoviesBinding
import com.wildan.wemovies.core.domain.model.Movies

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    private var listData = ArrayList<Movies>()
    var onItemClick: ((Movies) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Movies>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMoviesBinding.bind(itemView)
        fun bind(data: Movies) {
            val backdropPath = ApiService.BASE_IMAGE_URL+data.backdrop_path
            with(binding) {
                Glide.with(itemView.context)
                    .load(backdropPath)
                    .into(ivItemlistPoster)
                tvItemlistJudul.text = data.title
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movies, parent, false))

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}