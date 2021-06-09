package io.github.thang86.movieapp.presentation.movies

import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import io.github.thang86.movieapp.base.view.BaseFragment
import io.github.thang86.movieapp.data.enum.MovieListPageType
import io.github.thang86.movieapp.data.model.uimodel.MovieViewItem
import io.github.thang86.movieapp.presentation.movies.adapter.MoviePagerAdapter
import io.github.thang86.movieapp.util.BasicViewPagerTransformation
import io.github.thang86.movieapp.R
import io.github.thang86.movieapp.databinding.FragmentMovieBinding

class MoviesFragment : BaseFragment<FragmentMovieBinding, MoviesViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_movie
    override val classTypeOfViewModel: Class<MoviesViewModel> = MoviesViewModel::class.java

    override fun init() {
        binding.vm = viewModel
        baseView = binding.baseView
    }

    override fun initStartRequest() {
        viewModel.getMovies()
    }

    override fun setupClickListeners() {
        binding.imageButtonSearch.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.cardViewToolbarContent to binding.cardViewToolbarContent.transitionName)
            findNavController().navigate(R.id.action_moviesFragment_to_searchFragment, null, null, extras)
        }

        binding.layoutPopularMovies.imageButtonMore.setOnClickListener { onMoreButtonClick(
            MovieListPageType.POPULAR) }
        binding.layoutUpComingMovies.imageButtonMore.setOnClickListener { onMoreButtonClick(
            MovieListPageType.UPCOMING) }
    }

    private fun onMoreButtonClick(movieListPageType: MovieListPageType) {
        findNavController().navigate(MoviesFragmentDirections.actionMoviesFragmentToMovieListFragment(pageType = movieListPageType))
    }

    private fun onMovieItemClick(movieItem: MovieViewItem) {
        findNavController().navigate(MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(movieId = movieItem.id))
    }

    override fun setUpViewModelStateObservers() {
        viewModel.liveDataViewState_.observe(viewLifecycleOwner) { setViewState(it) }
    }

    private fun setViewState(fragmentViewState: MoviesFragmentViewState) {
        setupSmallItemViewPagerAdapter(fragmentViewState.getPopularMovies().movies, binding.layoutPopularMovies.viewPager)
        setupSmallItemViewPagerAdapter(fragmentViewState.getNowPlayingMovies().movies, binding.layoutUpComingMovies.viewPager)
        setupLargeItemViewPagerAdapter(fragmentViewState.getUpComingMovies().movies)
    }

    private fun setupSmallItemViewPagerAdapter(movies: List<MovieViewItem>, viewPager: ViewPager) {
        MoviePagerAdapter(requireContext(), MoviePagerAdapter.ITEM_TYPE.SMALL).apply {
            setItem(movies)
            onMovieItemClick = ::onMovieItemClick
            viewPager.adapter = this
        }

    }

    private fun setupLargeItemViewPagerAdapter(movies: List<MovieViewItem>) {
        MoviePagerAdapter(requireContext(), MoviePagerAdapter.ITEM_TYPE.LARGE).apply {
            setItem(movies)
            onMovieItemClick = ::onMovieItemClick
            binding.viewPagerNowPlayingMovies.adapter = this
        }
        binding.viewPagerNowPlayingMovies.apply {
            pageMargin = 60
            setPageTransformer(false, BasicViewPagerTransformation())
            currentItem = movies.size / 2
        }
    }
}