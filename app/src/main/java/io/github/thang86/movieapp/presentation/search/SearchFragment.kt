package io.github.thang86.movieapp.presentation.search

import android.graphics.Color
import android.transition.TransitionInflater
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import io.github.thang86.movieapp.R
import io.github.thang86.movieapp.base.extension.clickSubmitButton
import io.github.thang86.movieapp.base.extension.hideKeyboard
import io.github.thang86.movieapp.base.extension.showKeyboard
import io.github.thang86.movieapp.base.view.BaseFragment
import io.github.thang86.movieapp.data.enum.MovieListPageType
import io.github.thang86.movieapp.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_search
    override val classTypeOfViewModel: Class<SearchViewModel> = SearchViewModel::class.java

    override fun init() {
        context?.let { sharedElementEnterTransition = TransitionInflater.from(it).inflateTransition(android.R.transition.move) }

        setupSearchView()
    }


    override fun setupClickListeners() {
        binding.imageButtonBack.setOnClickListener { findNavController().popBackStack() }

    }

    private fun setupSearchView() {
        (binding.searchView.findViewById(androidx.appcompat.R.id.search_src_text) as TextView).setTextColor(Color.WHITE)
        binding.searchView.clickSubmitButton { query ->
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMovieListFragment(pageType = MovieListPageType.SEARCH, searchQuery = query))
        }
    }

    override fun onStart() {
        super.onStart()
        binding.searchView.showKeyboard(requireActivity())
        binding.searchView.onActionViewExpanded()
    }

    override fun onStop() {
        super.onStop()
        binding.searchView.hideKeyboard(requireActivity())
    }

}
