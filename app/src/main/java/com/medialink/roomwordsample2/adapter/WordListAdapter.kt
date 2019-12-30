package com.medialink.roomwordsample2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.medialink.roomwordsample2.R
import com.medialink.roomwordsample2.model.Word
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class WordListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<WordListAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(word: Word) {
            itemView.tv_word.text = word.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(words[position])
    }

    internal fun setWord(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }
}