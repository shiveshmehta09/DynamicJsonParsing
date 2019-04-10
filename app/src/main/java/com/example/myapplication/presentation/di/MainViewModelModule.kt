package com.example.myapplication.presentation.di

import android.arch.lifecycle.ViewModel
import com.example.myapplication.presentation.albums.activity.MainViewModel
import com.example.myapplication.presentation.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}