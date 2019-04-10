package com.example.myapplication.presentation.di

import com.example.myapplication.application.MainApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        BuildersModule::class,
        AppModule::class,
        DataModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class]
)
interface AppComponent :AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>() {
        abstract fun networkModule(module: NetworkModule): Builder
        abstract fun appModule(module: AppModule): Builder
    }
}