package io.github.thang86.movieapp.util

import androidx.recyclerview.widget.GridLayoutManager

object SpanSizeLookup {
    val lookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            TODO("Not yet implemented")
        }

    }
}