package com.agobikk.cookeatenjoy.util

import android.content.Context

interface SavedShared {
    fun setFavorite(context: Context?, key: String, value: Boolean)
    fun getFavorite(context: Context?, key: String): Boolean
    fun setIsFirst(context: Context?, value: Boolean)
    fun getIsFirst(context: Context?,): Boolean
}