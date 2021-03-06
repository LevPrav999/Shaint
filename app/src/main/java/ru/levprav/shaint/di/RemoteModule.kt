package ru.levprav.shaint.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.levprav.shaint.BuildConfig
import ru.levprav.shaint.data.remote.ProductsApi
import ru.levprav.shaint.data.remote.RemoteDataSource

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(okHttpClient = get(), BuildConfig.BASE_URL) }
    single { provideMoviesApi(retrofit = get()) }
    single { provideRemoteDataSource(moviesApi = get()) }
}

private fun provideRemoteDataSource(moviesApi: ProductsApi) =
        RemoteDataSource(moviesApi)

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
} else OkHttpClient.Builder().build()

private fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
): Retrofit =
        Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()

private fun provideMoviesApi(retrofit: Retrofit): ProductsApi =
        retrofit.create(ProductsApi::class.java)