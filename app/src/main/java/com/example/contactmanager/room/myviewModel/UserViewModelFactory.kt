package com.example.contactmanager.room.myviewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactmanager.room.UserRepro
import java.lang.IllegalArgumentException

class UserViewModelFactory(private val repository: UserRepro):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view Model class")
    }
}