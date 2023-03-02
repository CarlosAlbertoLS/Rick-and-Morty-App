package com.example.rickandmorty.ui.listCharacter.characterList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.GetCharacterListUseCase
import com.example.rickandmorty.listCharacter.data.response.Characters
import com.example.rickandmorty.model.CharacterListRepository
import com.example.rickandmorty.ui.detailCharacter.characterDetail.CharacterDetailActivity
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    private val getCharacterListUseCase = GetCharacterListUseCase(CharacterListRepository())
    val itemList: MutableLiveData<List<Characters>> = MutableLiveData()
    val progressBarVisibility: MutableLiveData<Int> = MutableLiveData(View.VISIBLE)

    fun navigateToDetail(context: Context, id: String){
        val intent = Intent(context, CharacterDetailActivity::class.java)
        intent.putExtra(CharacterDetailActivity.EXTRA_ID, id)
        context.startActivity(intent)
    }

    fun characterList(){
        viewModelScope.launch {
            progressBarVisibility.postValue(View.VISIBLE)
            val myResponse = getCharacterListUseCase.invoke()
            if (myResponse.isSuccessful){
                val response = myResponse.body()
                if (response != null){
                    val items = response.results
                    itemList.postValue(items)
                    progressBarVisibility.postValue(View.GONE)
                }
            }else{
                Log.i("sonder", "no funciona :(")
                progressBarVisibility.postValue(View.GONE)
            }
        }
    }

}