package com.example.newspulse.domain.usecases

import com.example.newspulse.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

//Kullanıcı girişini kaydetmek ve okumak için UseCase sınıfları tanımlanmıştır.
//invoke fonksiyonu: Kullanıcının uygulamaya giriş yapıp yapmadığını okur ve bir Flow<Boolean> döndürür.
class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}