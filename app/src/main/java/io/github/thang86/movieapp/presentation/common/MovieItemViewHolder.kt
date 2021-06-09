package io.github.thang86.movieapp.presentation.common

import io.github.thang86.movieapp.base.adapter.BaseViewHolder
import io.github.thang86.movieapp.data.model.uimodel.MovieViewItem
import io.github.thang86.movieapp.databinding.ItemMovieListBinding

class MovieItemViewHolder(val binding: ItemMovieListBinding, val itemClick: ((MovieViewItem) -> Unit)?) : BaseViewHolder<MovieViewItem?>(binding.root) {

    override fun bind(data: MovieViewItem?) {
        if (data == null) return

        binding.movie = data
        binding.root.setOnClickListener {
            itemClick?.invoke(data)
        }
        binding.executePendingBindings()
    }


}