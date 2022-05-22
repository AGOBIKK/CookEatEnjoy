package com.agobikk.cookeatenjoy.aplication.di.modules

import androidx.lifecycle.ViewModelProvider
import com.agobikk.cookeatenjoy.aplication.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class CommonViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}