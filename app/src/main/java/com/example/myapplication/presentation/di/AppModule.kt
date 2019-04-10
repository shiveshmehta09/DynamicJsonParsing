package com.example.myapplication.presentation.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

@Module
class AppModule(context: Context) {

    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun provideAppContext(): Context = appContext
}