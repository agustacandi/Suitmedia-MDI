package dev.agustacandi.learn.suitmedia_1.data.user.remote

import dev.agustacandi.learn.suitmedia_1.data.user.model.UserApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("users")
    suspend fun getAllUsers(
        @Query("page") page: String = "1",
        @Query("per_page") perPage: String = "10"
    ): UserApiResponse
}