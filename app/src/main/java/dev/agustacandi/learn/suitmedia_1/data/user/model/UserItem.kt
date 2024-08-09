package dev.agustacandi.learn.suitmedia_1.data.user.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserItem(

    @Json(name="last_name")
    val lastName: String? = null,

    @Json(name="id")
    val id: Int? = null,

    @Json(name="avatar")
    val avatar: String? = null,

    @Json(name="first_name")
    val firstName: String? = null,

    @Json(name="email")
    val email: String? = null
)
