package dev.agustacandi.learn.suitmedia_1.di

import dev.agustacandi.learn.suitmedia_1.utils.PreferenceManager
import org.koin.dsl.module

val preferenceModule = module {
    single { PreferenceManager(get()) }
}