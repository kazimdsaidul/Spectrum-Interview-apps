package com.kazi.spectruminterview.data.db.entities

import androidx.room.PrimaryKey

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-12-01.
 */


data class Member(
    @PrimaryKey(autoGenerate = true)
    val Member_id: Int,
    val age: Int,
    var companyId: String
)


