package com.example.tasarimdeneme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlakalarAdapter(private val mContext:Context, private val plakalarListe:List<Plakalar>) : RecyclerView.Adapter<PlakalarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){
        var textViewPlakaNo : TextView
        var textViewPlakaAd : TextView
        var textViewTelefon : TextView
        var textViewNufus   : TextView

        init {
            textViewPlakaNo = tasarim.findViewById(R.id.textViewPlakaNo)
            textViewPlakaAd = tasarim.findViewById(R.id.textViewPlakaAd)
            textViewTelefon = tasarim.findViewById(R.id.textViewTelefon)
            textViewNufus   = tasarim.findViewById(R.id.textViewNufus)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim_plaka,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val plaka = plakalarListe.get(position)

        holder.textViewPlakaNo.text =plaka.plaka_no.toString()
        holder.textViewPlakaAd.text = plaka.plaka_ad
        holder.textViewTelefon.text = "Telefon Kod: ${plaka.plaka_sehir_telefon}"
        holder.textViewNufus.text = "Nüfus: ${plaka.plaka_sehir_nufus}"

    }

    override fun getItemCount(): Int {
        return plakalarListe.size
    }

}