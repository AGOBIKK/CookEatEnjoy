package com.agobikk.cookeatenjoy

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.agobikk.cookeatenjoy.aplication.App
import com.agobikk.cookeatenjoy.data.local.Database
import com.agobikk.cookeatenjoy.data.local.RoomConstants
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredient
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformation
import kotlinx.coroutines.*
import timber.log.Timber
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        val scope = CoroutineScope(Dispatchers.Default)
        var job: Job? = null


//        val db = Room.databaseBuilder(
//            applicationContext,
//            Database::class.java,
//            RoomConstants.DATABASE_NAME
//        )
////            .fallbackToDestructiveMigration() // удаляет базу данных
////            .allowMainThreadQueries()     //запуск запросов в основном потоке
//            .build()
//

        val ingredient =
            ExtendedIngredient(4444, 5.0, "url_122222222", "url_122222", "22222", "66666", "massa")
        val foodInformation = FoodInformation(
            211111112,
            "image_food_url",
            "inst",
            "titledhfksdh",
            "sorceNamehsdkfh",
            extendedIngredient = ingredient
        )

        //        Executors.newSingleThreadExecutor().execute{
//
//        }
        fun printLog() {
            job?.cancel()
            job = scope.launch {
                App.instance.databaseService.getFoodInformation().insertFoodInfo(foodInformation)
                delay(1000)
                Timber.d("VVV:${App.instance.databaseService.getFoodInformation().getFoodInfo()}")
            }
        }
        printLog()

//        db.getFoodInformation().getFoodInfo(foodInformation)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



}