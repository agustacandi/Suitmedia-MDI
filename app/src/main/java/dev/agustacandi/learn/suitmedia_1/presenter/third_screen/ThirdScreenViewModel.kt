package dev.agustacandi.learn.suitmedia_1.presenter.third_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User
import dev.agustacandi.learn.suitmedia_1.domain.user.usecase.UserUseCase

class ThirdScreenViewModel(userUseCase: UserUseCase) : ViewModel() {
    val user: LiveData<PagingData<User>> =
        userUseCase.getAllUsers().cachedIn(viewModelScope)
}