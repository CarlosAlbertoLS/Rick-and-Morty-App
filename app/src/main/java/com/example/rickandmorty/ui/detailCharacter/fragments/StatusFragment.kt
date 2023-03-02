package com.example.rickandmorty.ui.detailCharacter.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentStatusBinding

class StatusFragment : Fragment() {
    private var statusCharacter: String? = null
    private var species: String? =  null
    private var gender: String? =  null
    private var type: String? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            statusCharacter = it.getString(STATUS_BUNDLE)
            species = it.getString(SPECIES_BUNDLE)
            gender = it.getString(GENDER_BUNDLE)
            type = it.getString(TYPE_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(arguments != null) {
            val status: TextView = view!!.findViewById(R.id.status)
            val species: TextView = view!!.findViewById(R.id.species)
            val gender: TextView = view!!.findViewById(R.id.gender)
            val type: TextView = view!!.findViewById(R.id.type)
            status.text = "Estado: $statusCharacter"
            species.text = "Especie: ${this.species}"
            gender.text = "Genero: ${this.gender}"
            type.text = "Tipo: ${this.type}"
        }
    }

    companion object {
        const val STATUS_BUNDLE = "param1"
        const val SPECIES_BUNDLE = "param2"
        const val GENDER_BUNDLE = "param3"
        const val TYPE_BUNDLE = "param4"
    }
}