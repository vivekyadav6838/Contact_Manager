package com.example.contactmanager.room.myviewModel


import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactmanager.room.User
import com.example.contactmanager.room.UserRepro
import kotlinx.coroutines.launch

class UserViewModel(private val repository:UserRepro):ViewModel(), androidx.databinding.Observable {
    val user = repository.users
    private  var isUpdateorDelete = false
    private lateinit var userToUpdateorDelete:User
    @Bindable
    val inputName = MutableLiveData<String?>()
    @Bindable
    val inputEmail = MutableLiveData<String?>()
    @Bindable
    val saveOrUpadteButton =MutableLiveData<String>()
    @Bindable
    val clearALlorDeleteButton = MutableLiveData<String>()

    init {
        saveOrUpadteButton.value ="Save"
        clearALlorDeleteButton.value="Clear All"
    }
    fun saveOrUpdate()
    {
        if(isUpdateorDelete)
        {
            userToUpdateorDelete.name =inputName.value!!
            userToUpdateorDelete.email = inputEmail.value!!
            update(userToUpdateorDelete)

        }
        else{
            val name = inputName.value!!
            val email = inputEmail.value!!

            insert(User(0,name, email))

            inputName.value=null
            inputEmail.value=null
        }
    }
    fun clearAllorDelete()
    {
        if(isUpdateorDelete)
        {
            delete(userToUpdateorDelete)
        }
        else{
        clearAll()}
    }
    fun insert(user: User)=viewModelScope.launch {
        repository.insert(user)
    }
    fun clearAll()=viewModelScope.launch {
        repository.deleteAll()
    }
    fun update(user: User)=viewModelScope.launch {
        repository.update(user)
// reseting the field
        inputName.value =null
        inputEmail.value=null
        isUpdateorDelete=false
        saveOrUpadteButton.value="Save"
        clearALlorDeleteButton.value="Clear All"

    }
    fun delete(user: User)=viewModelScope.launch {
        repository.delete(user)
        inputName.value =null
        inputEmail.value=null
        isUpdateorDelete=false
        saveOrUpadteButton.value="Save"
        clearALlorDeleteButton.value="Clear All"
    }


    fun initUpdateAndDelete(user: User)
    {
        inputName.value =user.name
        inputEmail.value=user.email
        isUpdateorDelete=true
        userToUpdateorDelete=user
        saveOrUpadteButton.value="Update"
        clearALlorDeleteButton.value="Delete"

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}