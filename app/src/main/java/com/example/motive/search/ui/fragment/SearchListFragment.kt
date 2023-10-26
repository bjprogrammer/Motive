package com.example.motive.search.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.motive.base.BaseViewModelFragment
import com.example.motive.databinding.FragmentSearchBinding
import com.example.motive.search.ui.adapter.SearchAdapter
import com.example.motive.search.ui.viewmodel.SearchViewModel
import com.example.motive.utils.Response
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class SearchListFragment : BaseViewModelFragment<FragmentSearchBinding, SearchViewModel>(
    inflate = FragmentSearchBinding::inflate,
    viewModelClass = SearchViewModel::class
) {
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun FragmentSearchBinding.setupViews(
        view: View,
        savedInstanceState: Bundle?,
        viewModel: SearchViewModel
    ) {
        searchAdapter = SearchAdapter {
            // Handle on click listener for future use
        }
        searchList.adapter = searchAdapter
        brnSearch.setOnClickListener {
            viewModel.searchText(tvSearch.text.toString())
        }
    }

    override fun FragmentSearchBinding.observeViewModel(vm: SearchViewModel) {
        vm.apply {
            searchLiveData.observe(viewLifecycleOwner) {
                when (it) {
                    is Response.Loading -> {
                        progressbar.visibility = View.VISIBLE
                    }

                    is Response.Success -> {
                        progressbar.visibility = View.GONE
                        it.data?.apply {
                            searchAdapter.updateList(this)
                        }
                    }

                    is Response.Error -> {
                        progressbar.visibility = View.GONE
                        // Show error dialog
                    }
                }
            }
        }
    }

    internal companion object CardSharingFragment {
        const val SEARCH_BACKSTACK = "SearchBackstack"

        @JvmStatic
        fun newInstance() = SearchListFragment()
    }
}