package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter(
    private val listOfContact: List<ContactItem>
):RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder>() {
    class ContactListViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val phoneNumber = view.findViewById<TextView>(R.id.phoneno)
        val imageRes = view.findViewById<ImageView>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_rv_item,parent,false)
        return ContactListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listOfContact.size
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        holder.name.text = listOfContact[position].name
        holder.phoneNumber.text = listOfContact[position].phoneNumber
        holder.imageRes.setImageURI(listOfContact[position].imageRes)
    }

}