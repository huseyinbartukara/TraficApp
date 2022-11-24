package com.example.tasarimdeneme

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi (context: Context) : SQLiteOpenHelper(context,"plakalar.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS \"plakalar\" (\n" +
                "\t\"plaka_id\"\tINTEGER,\n" +
                "\t\"plaka_ad\"\tTEXT,\n" +
                "\t\"plaka_no\"\tTEXT,\n" +
                "\t\"plaka_sehir_telefon\"\tTEXT,\n" +
                "\t\"plaka_sehir_nufus\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"plaka_id\" AUTOINCREMENT)\n" +
                ");")

        db?.execSQL("CREATE TABLE IF NOT EXISTS \"levhalar\" (\n" +
                "\t\"levha_id\"\tINTEGER,\n" +
                "\t\"levha_ad\"\tTEXT,\n" +
                "\t\"levha_resim\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"levha_id\" AUTOINCREMENT)\n" +
                ");")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS plakalar")
        db?.execSQL("DROP TABLE IF EXISTS levhalar")
        onCreate(db)
    }

}