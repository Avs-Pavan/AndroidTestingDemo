package com.kevin.androidtestingdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevin.androidtestingdemo.model.data.Article
import com.kevin.androidtestingdemo.model.repo.IRemoteNewRepository
import com.kevin.androidtestingdemo.util.network.APIResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: IRemoteNewRepository) :
    ViewModel() {

    // backing live data
    private val _newsLiveData = MutableLiveData<APIResponse<Article?>>().apply {
        value = APIResponse.Initial
    }

    // exposed live data
    val quotationLiveData: LiveData<APIResponse<Article?>>
        get() = _newsLiveData


    fun getQuotation() {

        viewModelScope.launch(Dispatchers.IO) {
            _newsLiveData.postValue(APIResponse.Loading)
            val response = repository.getNews()
            if (response.isSuccessful) {
                _newsLiveData.postValue(APIResponse.OnSuccess(response.body()?.articles?.random()))
            } else {
                _newsLiveData.postValue(APIResponse.OnError("Some thing went wrong"))
            }
        }

    }

}