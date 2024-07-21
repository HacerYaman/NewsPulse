package com.example.newspulse.domain.manager

//kullanıcı girişini kaydetmek ve okumak için gereken işlevleri tanımlar.

interface LocalUserManager {

    //user enter

    suspend fun saveAppEntry()



    fun readAppEntry(): kotlinx.coroutines.flow.Flow<Boolean>
}