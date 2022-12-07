package com.example.entities.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel, B: ViewBinding>(private val type: Class<out T>): Fragment() {

    protected lateinit var viewBinding: B
    protected lateinit var viewModel: T

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = provideViewModel()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject(activity?.application as BaseApplication)
        viewModel = provideViewModel()
        Log.i("BaseFragment", "onCreateView: viewModel initialized")
        lifecycle.addObserver(viewModel)
        viewBinding = initBinding(inflater, container, savedInstanceState)





        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("BaseFragment", "onViewCreated: viewModel used")
        initVars()
    }

    private fun provideViewModel(): T = ViewModelProvider(this, viewModelFactory)[type]

    protected abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): B
    protected abstract fun inject(app: BaseApplication)
    protected open fun initVars() = Unit

}