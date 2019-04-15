package com.example.myapplication.presentation.albums.fragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.myapplication.domain.usecase.GetTabs
import com.example.myapplication.domain.usecase.Result
import com.example.myapplication.presentation.TabData
import com.example.myapplication.presentation.albums.viewstate.MainViewState
import com.example.myapplication.presentation.utils.map
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
class PictureListViewModel @Inject constructor(private val getTabs: GetTabs) : ViewModel() {

    private val tabsResult = MutableLiveData<Result<List<TabData>?>>()
    private val _viewState = MutableLiveData<MainViewState>()
    val tabLiveData: LiveData<List<TabData>?>

    val viewState: LiveData<MainViewState>
        get() = _viewState


    init {
        _viewState.value = MainViewState(true)

        tabLiveData = tabsResult.map {
            _viewState.value = viewState.value?.copy(showLoading = false, showError = false)
            (it as? Result.Success<List<TabData>?>)?.data
        }
    }

    fun fetchTabs() {
        _viewState.value = viewState.value?.copy(showLoading = true)
        getTabs(Unit, tabsResult)
    }

}
