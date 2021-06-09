package io.github.thang86.movieapp.util

import androidx.recyclerview.widget.DiffUtil
import io.github.thang86.movieapp.data.model.uimodel.MovieViewItem

object MovieItemDiffCallback {
    val diffCallback = object : DiffUtil.ItemCallback<MovieViewItem>() {
        override fun areItemsTheSame(oldItem: MovieViewItem, newItem: MovieViewItem): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: MovieViewItem, newItem: MovieViewItem): Boolean = oldItem == newItem
    }
}