package com.mughitszufar.nvvmnewsapp.database

import androidx.room.TypeConverter
import com.mughitszufar.nvvmnewsapp.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source : Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}