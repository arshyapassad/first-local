package com.example.localproject.data.di.repositoryModule

import com.example.localproject.data.repository.homeRepository.HomeRepository
import com.example.localproject.data.repository.homeRepository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepositoryHome(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}