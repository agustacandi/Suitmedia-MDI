package dev.agustacandi.learn.suitmedia_1.di

import dev.agustacandi.learn.suitmedia_1.presenter.third_screen.ThirdScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ThirdScreenViewModel(get())
    }
}