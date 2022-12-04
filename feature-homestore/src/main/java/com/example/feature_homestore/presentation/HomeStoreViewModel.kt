package com.example.feature_homestore.presentation

import androidx.lifecycle.ViewModel
import com.example.api.interactors.GetHomePageFromRemote
import com.example.api.interfaces.Repository
import com.example.api.models.BestSellers
import com.example.api.models.HomePage
import com.example.api.models.HotSales
import com.example.api.type.Failure
import com.example.entities.None
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeStoreViewModel @Inject constructor(
    private val getHomePageFromRemote: GetHomePageFromRemote
): ViewModel() {

    fun loadHomePage(){
        getHomePageFromRemote(None()) {
            it.either(::onLoadDataFailed, ::homePageLoaded)
        }
    }

    private fun homePageLoaded(data: Response<HomePage>){
        if (data.isSuccessful){
            if (data.body() != null) {
                _bestSellersList.value = data.body()!!.bestSellers
            }
        }

    }

    private fun onLoadDataFailed(failure: Failure){
        when(failure){
            Failure.NetworkConnectionError -> TODO()
            Failure.ServerError -> TODO()
            Failure.ServerNotFoundError -> TODO()
            Failure.AuthorizationError -> TODO()
            Failure.AccountNotFoundError -> TODO()
            Failure.UnknownError -> TODO()
        }
    }
    private val _bestSellersList = MutableStateFlow<List<BestSellers>>(emptyList())
    val bestSellersList = _bestSellersList as StateFlow<List<BestSellers>>

    private val _hotSalesList = MutableStateFlow<List<HotSales>>(emptyList())
    val hotSalesList = _hotSalesList as StateFlow<List<HotSales>>
}