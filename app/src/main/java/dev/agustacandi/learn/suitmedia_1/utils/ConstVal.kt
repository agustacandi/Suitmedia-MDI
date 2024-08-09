package dev.agustacandi.learn.suitmedia_1.utils

import dev.agustacandi.learn.suitmedia_1.di.feature.userModule
import dev.agustacandi.learn.suitmedia_1.di.networkModule
import dev.agustacandi.learn.suitmedia_1.di.preferenceModule
import dev.agustacandi.learn.suitmedia_1.di.viewModelModule

object ConstVal {
    // List of Koin modules
    val koinModules = listOf(networkModule, viewModelModule, userModule, preferenceModule)

    // Base URL for the API
    const val BASE_URL = "https://reqres.in/api/"

    const val PREFS_NAME = "user.pref"
    const val KEY_NAME = "key.name"
}