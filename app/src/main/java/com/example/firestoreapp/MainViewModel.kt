package com.example.firestoreapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MainViewModel : ViewModel() {

    fun loadData(){
        viewModelScope.launch (Dispatchers.IO){
            Firebase.firestore
                .collection("cities")
                .document("db8608bc")
                .set(
                    City("db8608bc", "USA", "San Francisco", 860000, 121.4, arrayListOf("Z", "A"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("5c5b8399")
                .set(
                    City("5c5b8399","USA", "Los Angeles", 3900000,  1302.0,arrayListOf("B", "Q"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("26c1a9c7")
                .set(
                    City("26c1a9c7","USA", "Washington, D.C", 680000, 177.0,arrayListOf("C", "W"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("26c1a9c7")
                .set(
                    City("26c1a9c7","Japan", "Tokio", 9000000, 2187.0,arrayListOf("W", "F"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("e9df2cb8")
                .set(
                    City("e9df2cb8","Mexico", "Ciudad de México", 8800000, 1485.0,arrayListOf("Z", "R"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("306f85d2")
                .set(
                    City("306f85d2","China", "Beijing", 21500000, 16411.0,arrayListOf("G", "A"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("43dbe338")
                .set(
                    City("43dbe338","Colombia", "Bogotá", 7100000, 1775.0,arrayListOf("H", "E"))
                ).await()


            Firebase.firestore
                .collection("cities")
                .document("e9211d10")
                .set(
                    City("e9211d10","Colombia", "Cali", 2200000, 564.0,arrayListOf("I", "Q"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("9c8d8090")
                .set(
                    City("9c8d8090","Colombia", "Ibagué", 529000, 1378.0,arrayListOf("L", "M"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("9fef8768")
                .set(
                    City("9fef8768","USA", "New York", 8300000, 468.9, arrayListOf("N", "Z"))
                ).await()

            Firebase.firestore
                .collection("cities")
                .document("69da425e")
                .set(
                    City("69da425e","Argentina", "Buenos Aires", 15100000, 203.0, arrayListOf("D", "L"))
                ).await()


        }
    }

    //city cuyo pais no es el de la entrada + rango population
    fun query1(country:String, min:Int, max:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val result = Firebase.firestore.collection("cities")
                .whereNotEqualTo("city", country)
                .whereGreaterThan("population", min)
                .whereLessThan("population", max)
                .get()
                .await()

            val resultArray:List<City?> = result.documents.map { document ->
                document.toObject(City::class.java)
            }
            
            result.documents.forEach { document ->
                val city = document.toObject(City::class.java)
                Log.e(">>>", city?.city ?: "NO_NAME")
            }
        }

    }


}