package com.yourname.mantracounter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yourname.mantracounter.model.Mantra

@Database(
    entities = [Mantra::class],
    version = 1,
    exportSchema = false
)
abstract class MantraDatabase : RoomDatabase() {

    abstract fun mantraDao(): MantraDao

    companion object {

        @Volatile
        private var INSTANCE: MantraDatabase? = null

        fun getDatabase(context: Context): MantraDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MantraDatabase::class.java,
                    "mantra_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}