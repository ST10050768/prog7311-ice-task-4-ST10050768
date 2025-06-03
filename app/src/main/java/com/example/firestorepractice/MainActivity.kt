package com.example.firestorepractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    lateinit var FireStore: FirebaseFirestore
    lateinit var editData: EditText
    lateinit var btnAddData: Button
    lateinit var  btnShowGraph: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        editData = findViewById(R.id.editData)
        btnAddData = findViewById(R.id.btnaddData)
        btnShowGraph = findViewById(R.id.btnShowGraph)

        btnAddData.setOnClickListener{
            val dataString = editData.text.toString()
            try{
                val data =  dataString.toDouble()
                FireStore.collection("data").add(mapOf("value" to data))
            }catch (e: NumberFormatException){
                Toast.makeText(this, "Please enter a number",Toast.LENGTH_LONG)
            }
        }
        btnShowGraph.setOnClickListener{
            startActivity(Intent(this,GraphActivity::class.java))
        }
    }
}