package com.zahra.domain.di

import com.zahra.domain.repository.GalleryRepository
import com.zahra.domain.usecase.GetObjectDetailsByIdUseCase
import com.zahra.domain.usecase.GetObjectDetailsByIdUseCaseImp
import com.zahra.domain.usecase.GetObjectsByNameUseCase
import com.zahra.domain.usecase.GetObjectsByNameUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetObjectsByNameUseCase(
        repository: GalleryRepository
    ): GetObjectsByNameUseCase {
        return GetObjectsByNameUseCaseImp(repository)
    }

    @Provides
    @Singleton
    fun provideGetObjectDetailsByIdUseCase(
        repository: GalleryRepository
    ): GetObjectDetailsByIdUseCase {
        return GetObjectDetailsByIdUseCaseImp(repository)
    }


}