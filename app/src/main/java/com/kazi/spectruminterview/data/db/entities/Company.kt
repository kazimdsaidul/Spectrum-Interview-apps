package com.kazi.spectruminterview.data.db.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kazi.spectruminterview.ui.home.MemberTypeConverter


@Entity(indices = [Index(value = ["_id"], unique = true)])
@TypeConverters(MemberTypeConverter::class)

data class Company(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val _id: String,
    val about: String,
    val company: String,
    val logo: String,
    var members: List<Member>,
    val website: String
)