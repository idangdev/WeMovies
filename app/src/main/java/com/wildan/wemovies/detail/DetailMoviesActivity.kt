package com.wildan.wemovies.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.wildan.wemovies.R
import com.wildan.wemovies.core.data.source.remote.network.ApiService
import com.wildan.wemovies.core.domain.model.Movies
import com.wildan.wemovies.databinding.ActivityDetailMoviesBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMoviesViewModel: DetailMoviesViewModel by viewModel()
    private lateinit var binding: ActivityDetailMoviesBinding
    private lateinit var backdropPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovies = intent.getParcelableExtra<Movies>(EXTRA_DATA)
        showDetailMovies(detailMovies)


    }

    private fun showDetailMovies(detailMovies: Movies?) {
        backdropPath = ApiService.BASE_IMAGE_URL+detailMovies?.backdrop_path
        detailMovies?.let {
            supportActionBar?.title = detailMovies.title
            Glide.with(this@DetailMoviesActivity)
                .load(backdropPath)
                .into(binding.ivDetailPoster)
            binding.tvDetailJudul.text = detailMovies.title
            binding.tvReleaseDate.text = detailMovies.release_date
            binding.tvDetailDesc.text = detailMovies.overview


            var statusBookmark = detailMovies.isBookmark
            setStatusBookmark(statusBookmark)
            binding.floatingButton.setOnClickListener {
                statusBookmark = !statusBookmark
                detailMoviesViewModel.setBookmarkMovies(detailMovies, statusBookmark)
                setStatusBookmark(statusBookmark)
            }

        }
    }

    private fun setStatusBookmark(statusBookmark: Boolean) {
        if (statusBookmark) {
            binding.floatingButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bookmarked))
        }else {
            binding.floatingButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_no_bookmark))
        }
    }
}