package com.kevin.androidtestingdemo.model.repo.api


import com.kevin.androidtestingdemo.di.modules.Constants
import com.kevin.androidtestingdemo.model.data.RemoteNewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {

    @GET(Constants.ENDPOINT)
    suspend fun getNews(): Response<RemoteNewsResponse>

}