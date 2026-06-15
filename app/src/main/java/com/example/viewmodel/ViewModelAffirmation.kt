package com.example.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dailyaffirmationfirestore.Repository.FireStoreRepository

class ViewModelAffirmation: ViewModel() {
    private val firestoreRepository = FireStoreRepository()
    var affirmations by mutableStateOf<List<Pair<String, String>>>(emptyList())
        private set

    init {
        firestoreRepository.fetchAffirmations {
            updateAffirmations ->
            affirmations = updateAffirmations
        }
    }

    fun addAffirmation(affirmationText: String) = firestoreRepository.addAffirmation(affirmationText)

    fun deleteAffirmation(id: String) = firestoreRepository.deleteAffirmation(id)

    fun updateAffirmation(id: String, newAffirmationText: String) = firestoreRepository.updateAffirmation(id, newAffirmationText)

}