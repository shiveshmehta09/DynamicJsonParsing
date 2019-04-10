package com.example.myapplication.presentation.di

import com.example.myapplication.presentation.albums.activity.MainActivity
import com.example.myapplication.presentation.albums.fragment.PictureListFragment
import com.example.myapplication.presentation.di.annotations.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
@Module
abstract class BuildersModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [PictureListViewModelModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainViewModelModule::class])
    abstract fun bindPictureListFragment(): PictureListFragment
}