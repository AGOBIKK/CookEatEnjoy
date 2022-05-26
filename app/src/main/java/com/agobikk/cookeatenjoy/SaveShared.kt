package com.agobikk.cookeatenjoy

import android.content.Context
import androidx.preference.PreferenceManager


class SaveShared {
    companion object{
        fun setFavorite(context: Context?, key: String, value: Boolean){
            val setFavoriteShared = context?.let {
                PreferenceManager.getDefaultSharedPreferences(it) }
            setFavoriteShared
                ?.edit()
                ?.putBoolean(key, value)
                ?.apply()
        }
        fun getFavorite(context: Context?, key: String): Boolean{
            val getFavoriteShared = context?.let {
                PreferenceManager.getDefaultSharedPreferences(it) }
            return getFavoriteShared
                ?.getBoolean(key, false)
                ?: true
        }
    }
}
