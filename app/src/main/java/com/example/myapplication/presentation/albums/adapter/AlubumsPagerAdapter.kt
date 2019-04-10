package com.example.myapplication.presentation.albums.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.myapplication.presentation.utils.GET_PHOTOS
import com.example.myapplication.presentation.TabData
import com.example.myapplication.presentation.albums.fragment.PictureListFragment

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
class AlubumsPagerAdapter(fm: FragmentManager?, private val albumList: MutableList<TabData>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putString(GET_PHOTOS, albumList[position].url)
        val fragment = PictureListFragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return albumList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return albumList[position].title
    }
}