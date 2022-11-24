package com.example.tasarimdeneme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()

        quizButton.setOnClickListener {
                val intent = Intent(this@MainActivity,QuizActivity::class.java)
                startActivity(intent)
        }

        plakaButton.setOnClickListener{
            val intent = Intent(this@MainActivity,PlakaActivity::class.java)
            startActivity(intent)
        }

        yakitHesapButton.setOnClickListener {
            val intent = Intent(this@MainActivity,YakitHesapActivity::class.java)
            startActivity(intent)
        }

    }

    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this@MainActivity)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}