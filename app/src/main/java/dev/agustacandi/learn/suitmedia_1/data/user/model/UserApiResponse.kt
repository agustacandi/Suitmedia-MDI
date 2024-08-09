package dev.agustacandi.learn.suitmedia_1.data.user.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserApiResponse(

	@Json(name="per_page")
	val perPage: Int? = null,

	@Json(name="total")
	val total: Int? = null,

	@Json(name="data")
	val data: List<UserItem>? = null,

	@Json(name="page")
	val page: Int? = null,

	@Json(name="total_pages")
	val totalPages: Int? = null,

	@Json(name="support")
	val support: SupportResponse? = null
)