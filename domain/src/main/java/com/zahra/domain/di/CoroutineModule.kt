package com.zahra.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {

    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }
}

interface DispatcherProvider {
    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun default(): CoroutineDispatcher = Dispatchers.Default
    fun io(): CoroutineDispatcher = Dispatchers.IO
    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}

class DefaultDispatcherProvider @Inject constructor() : DispatcherProvider