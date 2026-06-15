package com.example.dailyaffirmationfirestore.Repository

import com.google.firebase.firestore.FirebaseFirestore

class FireStoreRepository {

    private val collection = FirebaseFirestore.getInstance().collection("affirmations")

    fun addAffirmation(text : String) {
        if(text.isNotBlank()){
            collection.add(mapOf("text" to text))
        }
    }

    fun fetchAffirmations(onAffirmationsChanged: (List<Pair<String,String>>) -> Unit) {
        collection.addSnapshotListener {  snapshot, _ ->
            val affirmationText = snapshot?.documents?.mapNotNull {document ->
                document.id to (document.getString("text") ?: "")
            } ?: emptyList()
            onAffirmationsChanged(affirmationText)

        }
    }

    fun updateAffirmation(id: String, newText: String) {
        collection.document(id).update("text", newText)
    }

    fun deleteAffirmation(id: String) {
        collection.document(id).delete()
    }

}