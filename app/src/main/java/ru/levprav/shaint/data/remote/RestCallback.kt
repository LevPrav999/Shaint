package ru.levprav.shaint.data.remote


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestCallback<T>(
        private val onLoadListener: OnLoadListener<T>
): Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            val responseBody: T? = response.body()
            onLoadListener.onLoadSuccess(responseBody!!)
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onLoadListener.onLoadFailure(t.localizedMessage)
    }
}

interface OnLoadListener<T> {
    fun onLoadSuccess(response: T)
    fun onLoadFailure(errorMsg: String)
}