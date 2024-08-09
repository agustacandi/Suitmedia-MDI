package dev.agustacandi.learn.suitmedia_1.data.user.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SupportResponse(

    @Json(name="text")
    val text: String? = null,

    @Json(name="url")
    val url: String? = null
)