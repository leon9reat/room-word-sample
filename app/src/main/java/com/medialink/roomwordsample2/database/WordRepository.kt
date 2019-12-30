package com.medialink.roomwordsample2.database

import androidx.lifecycle.LiveData
import com.medialink.roomwordsample2.model.Word

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getWords()

    suspend fun insert(aWord: Word) {
        wordDao.insert(aWord)
    }
}