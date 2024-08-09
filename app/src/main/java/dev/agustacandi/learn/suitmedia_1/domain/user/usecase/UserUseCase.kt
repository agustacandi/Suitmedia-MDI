package dev.agustacandi.learn.suitmedia_1.domain.user.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User

interface UserUseCase {

    fun getAllUsers(): LiveData<PagingData<User>>

}