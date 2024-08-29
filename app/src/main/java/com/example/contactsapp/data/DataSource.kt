package com.example.contactsapp.data

import com.example.contactsapp.R
import com.example.contactsapp.model.ContactInfo

class DataSource {
    fun getContactsList(): List<ContactInfo> {
        val contacts = mutableListOf<ContactInfo>()
        contacts.add(
            ContactInfo(R.string.auntie, R.string.auntieNum, R.drawable.auntie)
        )
        contacts.add(
            ContactInfo(R.string.brother, R.string.brotherNum, R.drawable.brother)
        )
        contacts.add(
            ContactInfo(R.string.daughter, R.string.daughterNum, R.drawable.daughter)
        )
        contacts.add(
            ContactInfo(R.string.friend_1, R.string.friend_1Num, R.drawable.friend_1)
        )
        contacts.add(
            ContactInfo(R.string.friend_2, R.string.friend_2Num, R.drawable.friend_2)
        )
        contacts.add(
            ContactInfo(R.string.grandfather, R.string.grandfatherNum, R.drawable.grandfather)
        )
        contacts.add(
            ContactInfo(R.string.granny, R.string.grannyNum, R.drawable.granny)
        )
        contacts.add(
            ContactInfo(R.string.neighbour, R.string.neighbourNum, R.drawable.neigbour)
        )
        contacts.add(
            ContactInfo(R.string.sister, R.string.sisterNum, R.drawable.sister)
        )
        contacts.add(
            ContactInfo(R.string.son, R.string.sonNum, R.drawable.son)
        )
        contacts.add(
            ContactInfo(R.string.uncle, R.string.uncleNum, R.drawable.uncle)
        )
        return contacts
    }
}