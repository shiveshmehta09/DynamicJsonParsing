package com.example.myapplication.presentation.di

import com.example.myapplication.data.remote.MainRemoteDataSource
import com.example.myapplication.data.remote.MainRepositoryImpl
import com.example.myapplication.data.local.MainLocalDataSource
import com.example.myapplication.data.remote.mapper.RemoteDataMapper
import com.example.myapplication.domain.MainRepository
import com.example.myapplication.data.remote.networkservice.Api
import dagger.Module
import dagger.Provides

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
@Module
class DataModule {

    @Provides
    fun provideLocalMainSource() = MainLocalDataSource()

    @Provides
    fun provideRemoteMainSource(api: Api, mapper: RemoteDataMapper) =
        MainRemoteDataSource(api, mapper)

    @Provides
    fun provideMainRepository(
        local: MainLocalDataSource,
        remote: MainRemoteDataSource
    ): MainRepository =
        MainRepositoryImpl(local, remote)
}