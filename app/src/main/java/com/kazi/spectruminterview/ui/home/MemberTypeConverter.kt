package com.kazi.spectruminterview.ui.home

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kazi.spectruminterview.data.db.entities.Member
import java.lang.reflect.Type


class MemberTypeConverter {
    @TypeConverter
    fun stringToMeasurements(json: String?): List<Member>? {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Member?>?>() {}.getType()
        return gson.fromJson<List<Member>>(json, type)
    }

    @TypeConverter
    fun measurementsToString(list: List<Member?>?): String? {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Member?>?>() {}.getType()
        return gson.toJson(list, type)
    }


}
