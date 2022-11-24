package com.example.tasarimdeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_yakit_hesap.*

class YakitHesapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yakit_hesap)

        buttonHesapla.setOnClickListener {

            val benzinFiyati = editTextBenzinFiyati.text.toString().trim()
            val yuzkmLitre = editTextLitre.text.toString().trim()
            val gidilenYol = editTextYol.text.toString().trim()
            var hesap:Float;

            if(TextUtils.isEmpty(benzinFiyati)){
                Snackbar.make(editTextBenzinFiyati,"Yakıt Fiyatını Giriniz...",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(yuzkmLitre)){
                Snackbar.make(editTextLitre,"100 km Başı Litre Fiyatını Giriniz...",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(gidilenYol)){
                Snackbar.make(editTextYol,"Yol Bilgisini Giriniz...",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            hesap = ((gidilenYol.toFloat()) * (yuzkmLitre.toFloat()) / 100) * benzinFiyati.toFloat()

            textViewHesaplama.text = "Yakıt Parası Tutarı: ${hesap} TL"

        }

    }
}