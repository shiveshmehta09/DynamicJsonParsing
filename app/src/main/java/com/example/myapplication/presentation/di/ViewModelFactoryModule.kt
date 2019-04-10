package com.example.myapplication.presentation.di

import android.arch.lifecycle.ViewModelProvider
import com.example.myapplication.presentation.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}