package com.medialink.roomwordsample2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.medialink.roomwordsample2.Consts

@Entity(tableName = Consts.TABLE_NAME)
data class Word (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "word") val word: String)