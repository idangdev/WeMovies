package com.wildan.wemovies.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.wemovies.bookmark.databinding.ActivityBookmarkBinding
import com.wildan.wemovies.core.ui.MoviesAdapter
import com.wildan.wemovies.detail.DetailMoviesActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class BookmarkActivity : AppCompatActivity() {

    private val bookmarkViewModel: BookmarkViewModel by viewModel()

    private var _binding: ActivityBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(bookmarkModule)

        supportActionBar?.title = "Bookmark"

        val moviesAdapter = MoviesAdapter()
        moviesAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailMoviesActivity::class.java)
            intent.putExtra(DetailMoviesActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        bookmarkViewModel.bookmarkMovies.observe(this, { dataMovies ->
            moviesAdapter.setData(dataMovies)
        })

        with(binding.rvMoviesBookmark) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}