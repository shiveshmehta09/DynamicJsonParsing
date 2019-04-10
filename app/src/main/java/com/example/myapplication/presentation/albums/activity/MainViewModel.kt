package com.example.myapplication.presentation.albums.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.myapplication.domain.entity.ProductsEntity
import com.example.myapplication.domain.usecase.GetPhotoList
import com.example.myapplication.domain.usecase.Result
import com.example.myapplication.presentation.albums.viewstate.MainViewState
import com.example.myapplication.presentation.utils.map
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
class MainViewModel @Inject constructor(private val getPhotoList: GetPhotoList) : ViewModel() {

    val productListResult = MutableLiveData<Result<List<ProductsEntity>?>>()
    private val _viewState = MutableLiveData<MainViewState>()

    val productList: LiveData<List<ProductsEntity>?>
    val viewState: LiveData<MainViewState>
        get() = _viewState


    init {
        _viewState.value = MainViewState(true)

        productList = productListResult.map {
            when (it) {
                is Result.Success<List<ProductsEntity>?> ->{
                    _viewState.value = viewState.value?.copy(showLoading = false, showError = false)
                    it.data
                }

                is Result.Error ->{
                    _viewState.value = viewState.value?.copy(showLoading = false, showError = true)
                null
                }
                Result.Loading -> null
            }
        }
    }


    fun fetchProductList(photoUrl:String) {
        _viewState.value = viewState.value?.copy(showLoading = true)
        getPhotoList(photoUrl, productListResult)
    }

}
