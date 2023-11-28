package com.kevin.androidtestingdemo.view.databinding

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.kevin.androidtestingdemo.model.data.Article
import com.kevin.androidtestingdemo.util.network.APIResponse

@BindingAdapter("showOnLoading")
fun ProgressBar.showOnLoading(responseState: APIResponse<Nothing>) {
    visibility = if (responseState is APIResponse.Loading)
        View.VISIBLE
    else
        View.GONE
}

@BindingAdapter("showQuotation")
fun TextView.showQuotation(responseState: APIResponse<Article>) {
    text = if (responseState is APIResponse.OnSuccess) {
        responseState.data.title
    } else {
        "Click refresh to fetch News"
    }
}
