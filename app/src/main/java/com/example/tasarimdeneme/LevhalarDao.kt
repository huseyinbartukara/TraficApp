package com.example.tasarimdeneme

class LevhalarDao {

    fun rasgele5LevhaGetir(vt:VeritabaniYardimcisi) : ArrayList<Levhalar>{

        val levhalarListe = ArrayList<Levhalar>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM levhalar ORDER BY RANDOM() LIMIT 5",null)

        while(c.moveToNext()){

            val levha = Levhalar(c.getInt(c.getColumnIndex("levha_id"))
                ,c.getString(c.getColumnIndex("levha_ad"))
                ,c.getString(c.getColumnIndex("levha_resim")))

            levhalarListe.add(levha)
        }
        return levhalarListe
    }


    fun rasgele3YanlisSecenekGetir(vt:VeritabaniYardimcisi,levha_id:Int) : ArrayList<Levhalar>{

        val levhalarListe = ArrayList<Levhalar>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM levhalar WHERE levha_id != $levha_id ORDER BY RANDOM() LIMIT 3",null)

        while(c.moveToNext()){

            val levha = Levhalar(c.getInt(c.getColumnIndex("levha_id"))
                ,c.getString(c.getColumnIndex("levha_ad"))
                ,c.getString(c.getColumnIndex("levha_resim")))

            levhalarListe.add(levha)
        }
        return levhalarListe
    }

}