package com.example.rickandmorty.ui.listCharacter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemCharacerBinding
import com.example.rickandmorty.listCharacter.data.response.Characters
import com.squareup.picasso.Picasso

class CharacterListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemCharacerBinding.bind(view)

    fun bind(characters: Characters, onItemSelected: (String) -> Unit) {
        binding.tvApiSuperheroName.text = characters.name
        Picasso.get().load(characters.image).into(binding.ivCharacter)
        binding.root.setOnClickListener { onItemSelected(characters.id) }
    }
}