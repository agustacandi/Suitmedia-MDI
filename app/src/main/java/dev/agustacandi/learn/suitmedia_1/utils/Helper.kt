package dev.agustacandi.learn.suitmedia_1.utils

import android.content.Context
import android.widget.Toast
import org.koin.core.context.GlobalContext.unloadKoinModules
import org.koin.core.context.loadKoinModules

object Helper {
    fun showToast(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun reloadKoinModules() {
        unloadKoinModules(ConstVal.koinModules)
        loadKoinModules(ConstVal.koinModules)
    }
}