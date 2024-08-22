package com.example.contactsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listOfContact = mutableListOf<ContactItem>()
        val rv = findViewById<RecyclerView>(R.id.rv)
        listOfContact.add(ContactItem(
            name = "Soumya",
            phoneNumber = "1234567890",
            imageRes = R.drawable.user
        ))
        listOfContact.add(ContactItem(
            name = "Soumya",
            phoneNumber = "1234567890",
            imageRes = R.drawable.man
        ))
        listOfContact.add(ContactItem(
            name = "Soumya",
            phoneNumber = "1234567890",
            imageRes = R.drawable.woman
        ))
        listOfContact.add(ContactItem(
            name = "Soumya",
            phoneNumber = "1234567890",
            imageRes = R.drawable.student
        ))
        listOfContact.add(ContactItem(
            name = "Soumya",
            phoneNumber = "1234567890",
            imageRes = R.drawable.teacher
        ))
        listOfContact.add(ContactItem(
            name = "Soumya",
            phoneNumber = "1234567890",
            imageRes = R.drawable.doctor
        ))
        val adapter = ContactListAdapter(listOfContact)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }
}