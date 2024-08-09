package dev.agustacandi.learn.suitmedia_1.di.feature

import dev.agustacandi.learn.suitmedia_1.data.user.UserRepositoryImpl
import dev.agustacandi.learn.suitmedia_1.domain.user.repository.UserRepository
import dev.agustacandi.learn.suitmedia_1.domain.user.usecase.UserInteractor
import dev.agustacandi.learn.suitmedia_1.domain.user.usecase.UserUseCase
import org.koin.dsl.module

val userModule = module {
    factory<UserRepository> {
        UserRepositoryImpl(get())
    }
    factory<UserUseCase> {
        UserInteractor(get())
    }
}