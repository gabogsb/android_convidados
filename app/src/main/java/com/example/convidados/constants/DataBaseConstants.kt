package com.example.convidados.constants

class DataBaseConstants private constructor() {


    object GUEST {

        const val ID = "guestId"

        const val TABLE_NAME = "GUEST"

        object COLUMNS {
            const val ID = "ID"
            const val NAME = "NAME"
            const val PRESENCE = "PRESENCE"
        }
    }


}