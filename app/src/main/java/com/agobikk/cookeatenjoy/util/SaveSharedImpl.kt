package com.agobikk.cookeatenjoy.util

import android.content.Context
import androidx.preference.PreferenceManager

const val KEY = "KEY"
class SaveSharedImpl:SavedShared {

       override fun setFavorite(context: Context?, key: String, value: Boolean){
            val setFavoriteShared = context?.let {
                PreferenceManager.getDefaultSharedPreferences(it) }
            setFavoriteShared
                ?.edit()
                ?.putBoolean(key, value)
                ?.apply()
        }
       override fun getFavorite(context: Context?, key: String): Boolean{
            val getFavoriteShared = context?.let {
                PreferenceManager.getDefaultSharedPreferences(it) }
            return getFavoriteShared
                ?.getBoolean(key, false)
                ?: true
        }
    override fun setIsFirst(context: Context?,value: Boolean){
        val setFavoriteShared = context?.let {
            PreferenceManager.getDefaultSharedPreferences(it) }
        setFavoriteShared
            ?.edit()
            ?.putBoolean(KEY, value)
            ?.apply()
    }
    override fun getIsFirst(context: Context?): Boolean{
        val getFavoriteShared = context?.let {
            PreferenceManager.getDefaultSharedPreferences(it) }
        return getFavoriteShared
            ?.getBoolean(KEY, false)
            ?: false
    }
}
