package com.example.myapplication.presentation.albums.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.domain.entity.ProductsEntity
import com.example.myapplication.presentation.albums.activity.MainViewModel
import com.example.myapplication.presentation.albums.adapter.PictureListAdapter
import com.example.myapplication.presentation.albums.viewstate.MainViewState
import com.example.myapplication.presentation.base.BaseFragment
import com.example.myapplication.presentation.factory.ViewModelFactory
import com.example.myapplication.presentation.utils.GET_PHOTOS
import kotlinx.android.synthetic.main.fragment_picture_list.view.*
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
class PictureListFragment : BaseFragment() {
    private lateinit var layoutView: View

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel

    override fun onCreateViewAfterViewStubInflated(inflatedView: View, savedInstanceState: Bundle?) {
        layoutView = inflatedView
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        init()
    }

    override fun getViewStubLayoutResource(): Int {
        return R.layout.fragment_picture_list
    }

    private fun init() {

        val albumUrl = arguments?.getString(GET_PHOTOS)
        viewModel.fetchProductList(albumUrl ?: "")

        viewModel.viewState.observe(this, Observer {
            if (it != null) {
                renderView(it)
            }
        })

        viewModel.productList.observe(this, Observer {
            if (it!!.isNotEmpty()) {
                setAdapter(it)
            } else {
                Toast.makeText(layoutView.context, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun renderView(viewState: MainViewState) {
        when (viewState.showLoading) {
            true -> {
                layoutView.progressBar.visibility = View.VISIBLE
            }
            false -> {
                layoutView.progressBar.visibility = View.GONE
            }
        }
    }

    private fun setAdapter(photoList: List<ProductsEntity>?) {
        layoutView.recyclerPhotos.layoutManager =
            GridLayoutManager(layoutView.context, 3, GridLayoutManager.VERTICAL, false)
        layoutView.recyclerPhotos.adapter =
            photoList?.let { PictureListAdapter(it) }
    }

}