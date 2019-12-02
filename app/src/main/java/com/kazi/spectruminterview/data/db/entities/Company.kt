package com.kazi.spectruminterview.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kazi.spectruminterview.ui.home.MemberTypeConverter


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-12-01.
 */
@Entity
@TypeConverters(MemberTypeConverter::class)

data class Company(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val _id: String,
    val about: String,
    val company: String,
    val logo: String,
    val members: List<Member>?

)




