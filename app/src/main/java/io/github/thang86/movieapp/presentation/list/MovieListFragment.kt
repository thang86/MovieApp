package io.github.thang86.movieapp.presentation.list

import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import io.github.thang86.movieapp.presentation.list.adapter.MovieListAdapter
import io.github.thang86.movieapp.R
import io.github.thang86.movieapp.base.view.BaseFragment
import io.github.thang86.movieapp.data.model.uimodel.MovieViewItem
import io.github.thang86.movieapp.databinding.FragmentMovieListBinding

class MovieListFragment : BaseFragment<FragmentMovieListBinding, MovieListViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_movie_list
    override val classTypeOfViewModel: Class<MovieListViewModel> = MovieListViewModel::class.java

    private val adapter: MovieListAdapter by lazy { MovieListAdapter() }

    override fun init() {
        baseView = binding.baseView
        binding.recyclerView.adapter = adapter
        (binding.recyclerView.layoutManager as GridLayoutManager).spanSizeLookup = adapter.spanSizeLookup

    }

    override fun setupClickListeners() {
        binding.imageButtonBack.setOnClickListener { activity?.onBackPressed() }
        adapter.onMovieItemClick = ::onMovieItemClick
    }

    override fun setUpViewModelStateObservers() {
        viewModel.getMovieList().observe(viewLifecycleOwner, ::onMovieListLoaded)
        viewModel.liveDataViewState_.observe(viewLifecycleOwner, ::setViewState)
    }

    private fun setViewState(fragmentViewState: MovieListFragmentViewState) {
        binding.viewState = fragmentViewState
        binding.executePendingBindings()
    }

    private fun onMovieListLoaded(movieList: PagedList<MovieViewItem>) {
        adapter.submitList(movieList)
    }

    private fun onMovieItemClick(movieViewItem: MovieViewItem) {
        findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(movieId = movieViewItem.id))
    }
}