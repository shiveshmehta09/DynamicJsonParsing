package com.example.myapplication.application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatDelegate
import com.example.myapplication.presentation.di.AppModule
import com.example.myapplication.presentation.di.NetworkModule
import com.example.myapplication.data.remote.networkservice.BASE_URL
import com.example.myapplication.presentation.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
class MainApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingActivityInjector

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate()
        appContext = applicationContext

        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule(BASE_URL))
            .create(this)
            .inject(this)
    }

}