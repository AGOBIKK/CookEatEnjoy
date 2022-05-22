package com.agobikk.cookeatenjoy.aplication

import android.app.Application
import com.agobikk.cookeatenjoy.aplication.di.AppComponent
import com.agobikk.cookeatenjoy.aplication.di.AppModule
import com.agobikk.cookeatenjoy.aplication.di.DaggerAppComponent
import com.agobikk.cookeatenjoy.data.local.Database
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

    class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .buildAppComp()



        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true) // (Optional) Whether to show thread info or not. Default true
            .methodCount(1) // (Optional) How many method line to show. Default 2
            .methodOffset(5) // Set methodOffset to 5 in order to hide internal method calls
            .tag("") // To replace the default PRETTY_LOGGER tag with a dash (-).
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))


        Timber.plant(object : Timber.DebugTree() {

            override fun log(
                priority: Int, tag: String?, message: String, t: Throwable?
            ) {
                Logger.log(priority, "-$tag", message, t)
            }
        })

        // Usage
        Timber.d("onCreate: Inside Application!")
    }

    init {
        instance = this
    }
    val databaseService: Database by lazy { Database.createDatabase(applicationContext)}


    companion object {
        lateinit var instance: App
            private set
    }
}
