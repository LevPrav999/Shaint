package ru.levprav.shaint

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.levprav.shaint.di.appModule
import ru.levprav.shaint.di.localModule
import ru.levprav.shaint.di.remoteModule
import ru.levprav.shaint.di.repositoryModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                    listOf(
                            localModule,
                            remoteModule,
                            repositoryModule,
                            appModule
                    )
            )
        }
    }
}