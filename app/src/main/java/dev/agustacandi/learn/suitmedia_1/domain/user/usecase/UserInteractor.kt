package dev.agustacandi.learn.suitmedia_1.domain.user.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User
import dev.agustacandi.learn.suitmedia_1.domain.user.repository.UserRepository

class UserInteractor(private val userRepository: UserRepository) : UserUseCase {
    override fun getAllUsers(): LiveData<PagingData<User>> = userRepository.getAllUsers()
}