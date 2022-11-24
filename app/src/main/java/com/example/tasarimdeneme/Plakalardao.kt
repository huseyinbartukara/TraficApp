package com.example.tasarimdeneme

class Plakalardao {

    fun tumPlakalar(vt:VeritabaniYardimcisi) : ArrayList<Plakalar>{
        val plakalarListe = ArrayList<Plakalar>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM plakalar",null)

        while(c.moveToNext()){
            val plaka = Plakalar(c.getInt(c.getColumnIndex("plaka_id"))
                ,c.getString(c.getColumnIndex("plaka_ad"))
                ,c.getString(c.getColumnIndex("plaka_no"))
                ,c.getString(c.getColumnIndex("plaka_sehir_telefon"))
                ,c.getString(c.getColumnIndex("plaka_sehir_nufus")))
            plakalarListe.add(plaka)
        }
        return plakalarListe
    }

    fun aramaYap(vt:VeritabaniYardimcisi,aramaKelime:String) : ArrayList<Plakalar>{
        val plakalarListe = ArrayList<Plakalar>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM plakalar WHERE plaka_no like '%$aramaKelime%'",null)

        while(c.moveToNext()){
            val plaka = Plakalar(c.getInt(c.getColumnIndex("plaka_id"))
                ,c.getString(c.getColumnIndex("plaka_ad"))
                ,c.getString(c.getColumnIndex("plaka_no"))
                ,c.getString(c.getColumnIndex("plaka_sehir_telefon"))
                ,c.getString(c.getColumnIndex("plaka_sehir_nufus")))
            plakalarListe.add(plaka)
        }
        return plakalarListe
    }

}