package com.celsoluiz73.businesscard.data

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Room
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

abstract class AppDatabase: RoomDatabase() {

    abstract fun businessDao() : BusinessCardDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

