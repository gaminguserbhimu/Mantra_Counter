package com.yourname.mantracounter.repository

import com.yourname.mantracounter.database.MantraDao
import com.yourname.mantracounter.model.Mantra
import kotlinx.coroutines.flow.Flow

class MantraRepository(
    private val mantraDao: MantraDao
) {

    val allMantras: Flow<List<Mantra>> =
        mantraDao.getAllMantras()

    suspend fun addMantra(mantra: Mantra) {
        mantraDao.insertMantra(mantra)
    }

    suspend fun deleteMantra(mantra: Mantra) {
        mantraDao.deleteMantra(mantra)
    }
}