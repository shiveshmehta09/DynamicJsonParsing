package com.example.myapplication.presentation.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.ProgressBar
import com.example.myapplication.R
import dagger.android.support.DaggerFragment

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
abstract class BaseFragment : DaggerFragment() {
    private var mSavedInstanceState: Bundle? = null
    private var hasInflated = false
    private var mViewStub: ViewStub? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.base_fragment, container, false)
        mViewStub = view.findViewById(R.id.fragmentViewStub) as ViewStub
        mViewStub?.layoutResource = getViewStubLayoutResource()
        mSavedInstanceState = savedInstanceState

        if (userVisibleHint && !hasInflated) {
            val inflatedView = mViewStub!!.inflate()
            onCreateViewAfterViewStubInflated(inflatedView, mSavedInstanceState)
            afterViewStubInflated(view)
        }

        return view
    }

    protected abstract fun onCreateViewAfterViewStubInflated(inflatedView: View, savedInstanceState: Bundle?)


    @LayoutRes
    protected abstract fun getViewStubLayoutResource(): Int


    @CallSuper
    protected fun afterViewStubInflated(originalViewContainerWithViewStub: View?) {
        hasInflated = true
        if (originalViewContainerWithViewStub != null) {
            val pb = originalViewContainerWithViewStub.findViewById<ProgressBar>(R.id.inflateProgressbar)
            pb.visibility = View.GONE
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (isVisibleToUser && mViewStub != null && !hasInflated) {
            val inflatedView = mViewStub!!.inflate()
            onCreateViewAfterViewStubInflated(inflatedView, mSavedInstanceState)
            afterViewStubInflated(view)
        }
    }

    override fun onDetach() {
        super.onDetach()
        hasInflated = false
    }
}