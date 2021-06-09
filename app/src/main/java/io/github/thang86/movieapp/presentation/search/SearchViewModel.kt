package io.github.thang86.movieapp.presentation.search

import androidx.databinding.ObservableField
import io.github.thang86.movieapp.base.viewmodel.BaseViewModel
import javax.inject.Inject

class SearchViewModel @Inject constructor() : BaseViewModel() {
    var query = ObservableField("")

}