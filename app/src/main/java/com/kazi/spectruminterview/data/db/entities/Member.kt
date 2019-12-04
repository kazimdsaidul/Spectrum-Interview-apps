package com.kazi.spectruminterview.data.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(indices = [Index(value = ["_id"], unique = true)])
data class Member(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val _id: String,
    var companyId: String,
    val age: Int,
    val email: String,
    @Embedded
    val name: Name,
    val phone: String
)