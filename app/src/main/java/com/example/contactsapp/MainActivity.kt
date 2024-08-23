package com.example.contactsapp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var dialogName: EditText
    private lateinit var dialogPh: EditText
    private lateinit var dialogImage: ImageView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
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
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            showDialog()
        }
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
    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_fab_dialog)
        dialogName = dialog.findViewById(R.id.dialog_name)
        dialogPh = dialog.findViewById(R.id.dialog_ph)
        dialogImage = dialog.findViewById(R.id.dialog_image)
        btn1 = dialog.findViewById(R.id.btn1)
        btn2 = dialog.findViewById(R.id.btn2)
        btn1.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery,101)
        }
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101 && resultCode == RESULT_OK){
            dialogImage.visibility = View.VISIBLE
            dialogImage.setImageURI(data?.data)
            btn2.setOnClickListener {
                val nameedt = dialogName.text.toString()
                val ph = dialogPh.text.toString()
                val imagepreview = data?.data

                val contact = ContactItem(
                    name = nameedt,
                    phoneNumber = ph,
                    imageRes = imagepreview
                )
            }
        }
    }
}