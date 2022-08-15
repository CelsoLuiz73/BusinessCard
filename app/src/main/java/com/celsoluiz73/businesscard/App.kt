package com.celsoluiz73.businesscard

import android.app.Application
import com.celsoluiz73.businesscard.data.AppDatabase
import com.celsoluiz73.businesscard.data.BusinessCardRepository
import kotlinx.coroutines.InternalCoroutinesApi

class App : Application() {
    @InternalCoroutinesApi
    private val database by lazy { AppDatabase.getDatabase(this)}
    @InternalCoroutinesApi
    val repository by lazy { BusinessCardRepository(database.businessDao())}
}