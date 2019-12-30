package com.medialink.roomwordsample2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.medialink.roomwordsample2.Consts
import com.medialink.roomwordsample2.model.Word

@Dao
interface WordDao {
    @Query("SELECT * FROM ${Consts.TABLE_NAME} ORDER BY word ASC")
    fun getWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM ${Consts.TABLE_NAME}")
    suspend fun deleteAll()
}