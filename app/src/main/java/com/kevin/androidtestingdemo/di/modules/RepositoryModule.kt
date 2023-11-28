package com.kevin.androidtestingdemo.di.modules

import com.kevin.androidtestingdemo.model.repo.IRemoteNewRepository
import com.kevin.androidtestingdemo.model.repo.RemoteNewsRepositoryImpl
import com.kevin.androidtestingdemo.model.repo.api.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(newsApiService: NewsApiService): IRemoteNewRepository {
        return RemoteNewsRepositoryImpl(newsApiService)
    }
}