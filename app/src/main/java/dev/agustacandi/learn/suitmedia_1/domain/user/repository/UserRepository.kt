package dev.agustacandi.learn.suitmedia_1.domain.user.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User

interface UserRepository {

    fun getAllUsers(): LiveData<PagingData<User>>

}