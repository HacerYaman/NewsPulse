package com.example.newspulse.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newspulse.domain.manager.LocalUserManager
import com.example.newspulse.util.Constants
import com.example.newspulse.util.Constants.USER_SETTING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// uygulayan bir sınıftır. Kullanıcı girişini kaydetmek ve okumak için gerekli işlevleri içerir.


class LocalUserManagerImp(
    private val context: Context,
) : LocalUserManager{

    //saveAppEntry fonksiyonu: Kullanıcının uygulamaya giriş yaptığını kaydeder.
    // Bu işlev, DataStore'u düzenleyerek PreferencesKeys.APP_ENTRY anahtarını true olarak ayarlar.

    override suspend fun saveAppEntry() {
        context.dataStore.edit {
            settings -> settings[PreferencesKeys.APP_ENTRY]=true
        }
    }

    //readAppEntry fonksiyonu: Kullanıcının uygulamaya giriş yapıp yapmadığını okur ve bir Flow<Boolean> döndürür.
    // Eğer giriş yapılmamışsa varsayılan değer olarak false döner.

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {
            preferences -> preferences[PreferencesKeys.APP_ENTRY]?:false
        }
    }
}

//Bu, Context sınıfına bir uzantı fonksiyonudur. DataStore'u USER_SETTING adıyla tanımlar
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name=USER_SETTING)

//Bu nesne, DataStore içindeki tercih anahtarlarını tanımlar.
// APP_ENTRY, bir Boolean değeri saklamak için bir anahtardır.

private object PreferencesKeys{
    val APP_ENTRY= booleanPreferencesKey(name =Constants.APP_ENTRY)
}