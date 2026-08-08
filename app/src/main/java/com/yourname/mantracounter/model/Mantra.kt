package com.yourname.mantracounter.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mantras")
data class Mantra(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val goal: Int
)