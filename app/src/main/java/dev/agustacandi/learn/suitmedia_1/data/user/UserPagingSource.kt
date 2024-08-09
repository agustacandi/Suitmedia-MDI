package dev.agustacandi.learn.suitmedia_1.data.user

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.agustacandi.learn.suitmedia_1.data.user.remote.UserService
import dev.agustacandi.learn.suitmedia_1.domain.user.mapper.toDomain
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User

class UserPagingSource(private val userService: UserService) : PagingSource<Int, User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val response = userService.getAllUsers(
                page = position.toString(),
                perPage = params.loadSize.toString()
            )
            val data = response.data

            LoadResult.Page(
                data = if (data.isNullOrEmpty()) listOf() else data.toDomain(),
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (data.isNullOrEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}