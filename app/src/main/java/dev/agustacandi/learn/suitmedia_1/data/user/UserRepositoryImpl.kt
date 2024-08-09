package dev.agustacandi.learn.suitmedia_1.data.user

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import dev.agustacandi.learn.suitmedia_1.data.user.remote.UserService
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User
import dev.agustacandi.learn.suitmedia_1.domain.user.repository.UserRepository

class UserRepositoryImpl(private val userService: UserService) : UserRepository {
    override fun getAllUsers(): LiveData<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                UserPagingSource(userService)
            }
        ).liveData
    }
}