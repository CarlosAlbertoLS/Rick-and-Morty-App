package com.example.rickandmorty.ui.detailCharacter.characterDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityCharacterDetailBinding
import com.example.rickandmorty.model.response.CharacterDetailResponse
import com.example.rickandmorty.ui.detailCharacter.fragments.EpisodesFragment
import com.example.rickandmorty.ui.detailCharacter.fragments.OriginFragment
import com.example.rickandmorty.ui.detailCharacter.fragments.StatusFragment
import com.example.rickandmorty.ui.detailCharacter.fragments.StatusFragment.Companion.GENDER_BUNDLE
import com.example.rickandmorty.ui.detailCharacter.fragments.StatusFragment.Companion.SPECIES_BUNDLE
import com.example.rickandmorty.ui.detailCharacter.fragments.StatusFragment.Companion.STATUS_BUNDLE
import com.example.rickandmorty.ui.detailCharacter.fragments.StatusFragment.Companion.TYPE_BUNDLE
import com.squareup.picasso.Picasso

class CharacterDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
    }
    private lateinit var binding: ActivityCharacterDetailBinding
    private val characterDetailViewModel: CharacterDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        initUI(id)

    }

    private fun initUI(id:String) {
        characterDetailViewModel.characterDetailData(id)
        characterDetailViewModel.detailCharacter.observe(this){ data ->
            Picasso.get().load(data.image).into(binding.ivPhoto)
            binding.characterName.text = data.name
            initFragments(data)
            initListeners(data)
        }
    }

    private fun initListeners(data: CharacterDetailResponse) {
        binding.tvOrigin.setOnClickListener { changeFragment(OriginFragment(),data) }
        binding.tvEpisodes.setOnClickListener { changeFragment(EpisodesFragment(), data) }
        binding.tvStatus.setOnClickListener { changeFragment(StatusFragment(), data) }
    }

    private fun changeFragment(fragment: Fragment, data: CharacterDetailResponse) {
        val status = data.status
        val species = data.species
        val gender = data.gender
        val type = data.type ?: "-"
        val bundle = bundleOf(
            STATUS_BUNDLE to status,
            SPECIES_BUNDLE to species,
            GENDER_BUNDLE to gender,
            TYPE_BUNDLE to type
        )
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = fragment
        newFragment.arguments = bundle
        transaction.replace(R.id.fragmentContainer, newFragment)
        transaction.commit()
    }

    private fun initFragments(data: CharacterDetailResponse) {
        val status = data.status
        val species = data.species
        val gender = data.gender
        val type = data.type ?: "-"
        val bundle = bundleOf(
            STATUS_BUNDLE to status,
            SPECIES_BUNDLE to species,
            GENDER_BUNDLE to gender,
            TYPE_BUNDLE to type
        )
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<StatusFragment>(R.id.fragmentContainer, args = bundle)
        }
    }
}