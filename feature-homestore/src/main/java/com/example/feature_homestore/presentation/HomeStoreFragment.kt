package com.example.feature_homestore.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.models.BestSellers
import com.example.entities.launchWhenStarted
import com.example.entities.presentation.base.BaseApplication
import com.example.entities.presentation.base.BaseFragment
import com.example.feature_homestore.adapters.BestSellerAdapter
import com.example.feature_homestore.databinding.FragmentHomeStoreBinding
import com.example.feature_homestore.di.components.HomeStoreComponent
import javax.inject.Inject

class HomeStoreFragment : BaseFragment<HomeStoreViewModel, FragmentHomeStoreBinding>(HomeStoreViewModel::class.java) {


    override fun initVars() {
        super.initVars()
        viewModel.loadHomePage()
        initViewModelVars()
    }


    private fun initViewModelVars(){
        viewModel.bestSellersList.launchWhenStarted(lifecycleScope) {
            setupBestSellersList(it)
        }

        viewModel.hotSalesList.launchWhenStarted(lifecycleScope) {

        }
    }

    private fun setupBestSellersList(bestSellersList: List<BestSellers>) {
        val bestSellersAdapter = BestSellerAdapter()
        with(viewBinding.bestSellersRcView) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = bestSellersAdapter
        }
        bestSellersAdapter.submitList(bestSellersList)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeStoreBinding {
        viewBinding = FragmentHomeStoreBinding.inflate(inflater, container, false)
        return viewBinding
    }

    override fun inject(app: BaseApplication) {
        app.getComponent<HomeStoreComponent>().inject(this)
    }

}