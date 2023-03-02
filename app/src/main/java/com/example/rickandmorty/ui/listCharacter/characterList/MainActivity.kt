package com.example.rickandmorty.ui.listCharacter.characterList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.domain.GetCharacterListUseCase
import com.example.rickandmorty.model.retrofit.RetrofitClient
import com.example.rickandmorty.model.CharacterClient
import com.example.rickandmorty.model.CharacterListRepository
import com.example.rickandmorty.ui.listCharacter.adapter.CharacterListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterListAdapter
    private val characterListViewModel: CharacterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        characterListViewModel.itemList.observe(this){items ->
            adapter.updateList(items)
        }
        characterListViewModel.progressBarVisibility.observe(this) { visibility ->
            binding.pbCharacterList.visibility = visibility
        }
    }

    private fun initUI() {
        characterListViewModel.characterList()
        adapter = CharacterListAdapter(){ characterListViewModel.navigateToDetail(this, it) }
        binding.rvCharacterList.setHasFixedSize(true)
        binding.rvCharacterList.layoutManager = GridLayoutManager(this, 2)
        binding.rvCharacterList.adapter = adapter
    }
}