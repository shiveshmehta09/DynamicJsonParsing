package com.example.myapplication.presentation.albums.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.domain.entity.TabListEntity
import com.example.myapplication.presentation.TabData
import com.example.myapplication.presentation.albums.adapter.AlubumsPagerAdapter
import com.example.myapplication.presentation.albums.fragment.PictureListViewModel
import com.example.myapplication.presentation.albums.viewstate.MainViewState
import com.example.myapplication.presentation.factory.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: PictureListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PictureListViewModel::class.java)
        viewModel.fetchTabs()

        init()
    }

    private fun init() {

        viewModel.viewState.observe(this, Observer {
            if (it != null) {
                renderView(it)
            }
        })

        viewModel.tabLiveData.observe(this, Observer {
         //   setAdapter(it)
            val adapter = AlubumsPagerAdapter(supportFragmentManager, it!!.toMutableList())

            pager.adapter = adapter
            tabLayout.setupWithViewPager(pager)
        })

    }

    private fun renderView(viewState: MainViewState) {
        when (viewState.showLoading) {
            true -> {
                progressBar.visibility = View.VISIBLE
            }
            false -> {
                progressBar.visibility = View.GONE
            }
        }
    }


    /*private fun setAdapter(list: TabListEntity?) {
        val tabData = mutableListOf<TabData>()
        list?.apiGroups?.affiliate?.apiListings?.forEach {
            val key = it.key
            val value = it.value
            tabData.add(
                TabData(
                    key,
                    value.version1?.version1?.getPhotos
                )
            )
        }

        val adapter = AlubumsPagerAdapter(supportFragmentManager, tabData)
        pager.adapter = adapter
        tabLayout.setupWithViewPager(pager)
    }*/
}
