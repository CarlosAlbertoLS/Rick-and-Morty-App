package com.example.rickandmorty.ui.listCharacter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.listCharacter.data.response.Characters

class CharacterListAdapter(var characterList: List<Characters> = emptyList(), private val onItemSelected: (String) -> Unit): RecyclerView.Adapter<CharacterListViewHolder>(){

    fun updateList(characterList: List<Characters>) {
        this.characterList = characterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_characer, parent, false)
        )
    }

    override fun getItemCount() = characterList.size

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(characterList[position], onItemSelected)
    }
}