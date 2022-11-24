package com.example.tasarimdeneme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val dogruSayac = intent.getIntExtra("dogruSayac",0)

        textViewSonuc.text = "$dogruSayac Doğru ${5-dogruSayac} Yanlış"

        textViewYuzdeSonuc.text = "%${(dogruSayac*100)/5} Başarı Oranı"

        buttonTekrar.setOnClickListener {
            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            finish()
        }

    }
}