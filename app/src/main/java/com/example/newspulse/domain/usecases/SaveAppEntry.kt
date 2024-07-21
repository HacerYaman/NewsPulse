package com.example.newspulse.domain.usecases

import com.example.newspulse.domain.manager.LocalUserManager


//Kullanıcı girişini kaydetmek ve okumak için UseCase sınıfları tanımlanmıştır.

class SaveAppEntry(
    private val localUserManager: LocalUserManager) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}