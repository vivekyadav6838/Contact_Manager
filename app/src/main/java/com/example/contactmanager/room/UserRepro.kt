package com.example.contactmanager.room

class UserRepro(private  var dao: DAO) {
    val users = dao.getAllUserInDB()
    suspend fun insert(user: User):Long{
        return dao.insertUser(user)
    }
    suspend fun  delete(user: User){
        return dao.deleteUser(user)
    }
    suspend fun  update(user: User){
        return  dao.updateUser(user)
    }
    suspend fun  deleteAll()
    {
        return dao.deleteAll()
    }
}