package com.yourname.mantracounter.database

import androidx.room.Update
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yourname.mantracounter.model.Mantra
import kotlinx.coroutines.flow.Flow

@Dao
interface MantraDao {

    @Insert
    suspend fun insertMantra(mantra: Mantra)

    @Delete
    suspend fun deleteMantra(mantra: Mantra)

    @Update
    suspend fun updateMantra(mantra: Mantra)

    @Query("SELECT * FROM mantras ORDER BY id ASC")
    fun getAllMantras(): Flow<List<Mantra>>
}