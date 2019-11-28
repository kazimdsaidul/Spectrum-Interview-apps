package com.kazi.spectruminterview.data.db.entities

data class ResDataAPI(
    val _id: String,
    val about: String,
    val company: String,
    val logo: String,
    val members: List<Member>,
    val website: String
)