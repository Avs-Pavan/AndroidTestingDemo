package com.kevin.androidtestingdemo.model.repo

import com.kevin.androidtestingdemo.model.data.RemoteNewsResponse
import com.kevin.androidtestingdemo.model.repo.api.NewsApiService
import retrofit2.Response
import javax.inject.Inject


class RemoteNewsRepositoryImpl @Inject constructor(private val newsApiService: NewsApiService) :
    IRemoteNewRepository {
    override suspend fun getNews(): Response<RemoteNewsResponse> = newsApiService.getNews()
}