package com.yourname.mantracounter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yourname.mantracounter.database.MantraDatabase
import com.yourname.mantracounter.model.Mantra
import com.yourname.mantracounter.repository.MantraRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MantraViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MantraRepository

    private val _mantras = MutableStateFlow<List<Mantra>>(emptyList())
    val mantras: StateFlow<List<Mantra>> = _mantras.asStateFlow()

    init {

        val database = MantraDatabase.getDatabase(application)

        repository = MantraRepository(
            database.mantraDao()
        )

        viewModelScope.launch {

            repository.allMantras.collect { mantraList ->

                _mantras.value = mantraList

                if (mantraList.isEmpty()) {

                    repository.addMantra(
                        Mantra(
                            name = "Om Namah Shivaya",
                            goal = 54
                        )
                    )

                    repository.addMantra(
                        Mantra(
                            name = "Gayatri Mantra",
                            goal = 108
                        )
                    )
                }
            }
        }
    }

    fun addMantra(name: String, goal: Int) {

        viewModelScope.launch {

            repository.addMantra(
                Mantra(
                    name = name,
                    goal = goal
                )
            )
        }
    }

    fun deleteMantra(mantra: Mantra) {

        viewModelScope.launch {

            repository.deleteMantra(mantra)
        }
    }

    fun getMantraById(id: Int): Mantra? {

        return _mantras.value.find {
            it.id == id
        }
    }
}