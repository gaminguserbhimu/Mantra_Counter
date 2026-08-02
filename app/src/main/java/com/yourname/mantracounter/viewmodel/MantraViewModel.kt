package com.yourname.mantracounter.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.yourname.mantracounter.model.Mantra

class MantraViewModel : ViewModel() {

    val mantras = mutableStateListOf(
        Mantra(1, "Om Namah Shivaya", 54),
        Mantra(2, "Gayatri Mantra", 108)
    )

    fun addMantra(name: String, goal: Int) {
        mantras.add(
            Mantra(
                id = mantras.size + 1,
                name = name,
                goal = goal
            )
        )
    }

    fun getMantraById(id: Int): Mantra? {

        return mantras.find {
            it.id == id
        }

    }
}