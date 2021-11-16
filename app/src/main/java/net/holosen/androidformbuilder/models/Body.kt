package net.holosen.androidformbuilder.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Body(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    var title: String,
    var content: String
)
