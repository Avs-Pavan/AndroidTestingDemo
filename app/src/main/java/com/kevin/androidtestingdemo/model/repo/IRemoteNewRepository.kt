package com.kevin.androidtestingdemo.model.repo


import com.kevin.androidtestingdemo.model.data.RemoteNewsResponse
import retrofit2.Response

interface IRemoteNewRepository {
    suspend fun getNews(): Response<RemoteNewsResponse>
}