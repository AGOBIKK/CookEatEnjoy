package com.agobikk.cookeatenjoy.aplication

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.agobikk.cookeatenjoy.aplication.di.AppComponent
import com.agobikk.cookeatenjoy.aplication.di.DaggerAppComponent

import com.agobikk.cookeatenjoy.aplication.di.modules.AppModule
import com.agobikk.cookeatenjoy.aplication.di.modules.RoomModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .setRoomModule(roomModule = RoomModule(applicationContext))
            .buildAppComp()
        super.onCreate()

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
    }



    init {
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
val Activity.appComponent get() = (application as App).appComponent

val Fragment.appComponent get() = (requireActivity().application as App).appComponent
