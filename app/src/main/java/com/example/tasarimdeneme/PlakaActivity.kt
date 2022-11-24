package com.example.tasarimdeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_plaka.*

class PlakaActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var plakalarListe:ArrayList<Plakalar>
    private lateinit var adapter: PlakalarAdapter
    private lateinit var vt: VeritabaniYardimcisi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plaka)

        veritabaniKopyala()

        toolbarPlaka.title = "Plakalar"
        setSupportActionBar(toolbarPlaka)

        rv.setHasFixedSize(true)

        vt = VeritabaniYardimcisi(this@PlakaActivity)

        rv.layoutManager = LinearLayoutManager(this@PlakaActivity)

        plakalarListe = Plakalardao().tumPlakalar(vt)

        adapter = PlakalarAdapter(this@PlakaActivity,plakalarListe)

        rv.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_tasarim,menu)

        val item = menu?.findItem(R.id.action_ara)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this@PlakaActivity)

        return super.onCreateOptionsMenu(menu)
    }




    override fun onQueryTextSubmit(query: String): Boolean {
        arama(query)
        Log.e("Gönderilen Arama" , query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        arama(newText)
        Log.e("harf Girdikçe:" , newText)
        return true
    }

    fun arama(aramaKelime:String){
        plakalarListe = Plakalardao().aramaYap(vt,aramaKelime)

        adapter = PlakalarAdapter(this@PlakaActivity,plakalarListe)

        rv.adapter = adapter
    }


    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this@PlakaActivity)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }


}