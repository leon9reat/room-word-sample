package com.medialink.roomwordsample2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.medialink.roomwordsample2.database.WordRepository
import com.medialink.roomwordsample2.database.WordRoomDatabase
import com.medialink.roomwordsample2.model.Word
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(aWord: Word) {
        viewModelScope.launch { repository.insert(aWord) }
    }
}