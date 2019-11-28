package com.kazi.spectruminterview.data.db.entities

data class Member(
    val _id: String,
    val age: Int,
    val email: String,
    val name: Name,
    val phone: String
)