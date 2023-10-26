package com.example.motive.search.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.motive.R
import com.example.motive.databinding.ActivityMainBinding
import com.example.motive.search.ui.fragment.SearchListFragment
import com.example.motive.search.ui.fragment.SearchListFragment.CardSharingFragment.SEARCH_BACKSTACK
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this@SearchActivity,
            R.layout.activity_main)
        .apply {
            init()
        }
    }

    fun ActivityMainBinding.init() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SearchListFragment.newInstance())
            .addToBackStack(SEARCH_BACKSTACK)
            .commit()

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }
}