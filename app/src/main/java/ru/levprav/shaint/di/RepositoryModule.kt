package ru.levprav.shaint.di

import org.koin.dsl.module
import ru.levprav.shaint.data.RepositoryImpl
import ru.levprav.shaint.data.local.ProductDao
import ru.levprav.shaint.data.remote.RemoteDataSource
import ru.levprav.shaint.domain.Repository

val repositoryModule = module {
    single { provideLocalRepository(movieDao = get(), remoteDataSource = get()) }
}

private fun provideLocalRepository(
        movieDao: ProductDao, remoteDataSource: RemoteDataSource
): Repository {
    return RepositoryImpl(movieDao, remoteDataSource)
}