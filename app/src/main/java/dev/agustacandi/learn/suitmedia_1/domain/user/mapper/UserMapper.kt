package dev.agustacandi.learn.suitmedia_1.domain.user.mapper

import dev.agustacandi.learn.suitmedia_1.data.user.model.UserItem
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User

fun List<UserItem>.toDomain(): List<User> {
    return this.map {
        User(
            lastName = it.lastName ?: "",
            id = it.id ?: 0,
            avatar = it.avatar ?: "",
            firstName = it.firstName ?: "",
            email = it.email ?: ""
        )
    }
}

fun UserItem.toDomain(): User {
    return User(
        lastName = this.lastName ?: "",
        id = this.id ?: 0,
        avatar = this.avatar ?: "",
        firstName = this.firstName ?: "",
        email = this.email ?: ""
    )
}