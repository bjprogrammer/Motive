package com.example.motive.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import kotlin.reflect.KClass

typealias InflateFragmentLayout<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseViewModelFragment<VB : ViewDataBinding, VM : ViewModel>(
    private val inflate: InflateFragmentLayout<VB>,
    viewModelClass: KClass<VM>
) : Fragment() {
    private var binding: VB? = null
    private val viewModel: VM by ViewModelLazy(
        viewModelClass,
        { requireActivity().viewModelStore },
        { defaultViewModelProviderFactory }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflate.invoke(inflater, container, false).apply { binding = this }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            setupViews(view, savedInstanceState, viewModel)
            observeViewModel(viewModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun getBinding() = binding
    fun getVM() = viewModel
    open fun VB.setupViews(view: View, savedInstanceState: Bundle?, viewModel: VM) { }
    open fun VB.observeViewModel(vm: VM) { }
}