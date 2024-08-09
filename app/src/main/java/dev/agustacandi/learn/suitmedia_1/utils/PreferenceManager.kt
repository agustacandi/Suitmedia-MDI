package dev.agustacandi.learn.suitmedia_1.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(ConstVal.PREFS_NAME, Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    val getName = prefs.getString(ConstVal.KEY_NAME, "")

    fun setNamePrefs(name: String) {
        editor.putString(ConstVal.KEY_NAME, name)
        editor.apply()
    }

    fun clearNamePrefs() {
        editor.remove(ConstVal.KEY_NAME)
        editor.apply()
    }
}