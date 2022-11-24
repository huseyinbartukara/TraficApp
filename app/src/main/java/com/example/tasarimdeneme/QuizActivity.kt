package com.example.tasarimdeneme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var sorular:ArrayList<Levhalar>
    private lateinit var yanlisSecenekler:ArrayList<Levhalar>
    private lateinit var dogruSoru:Levhalar
    private lateinit var tumSecenekler:HashSet<Levhalar>
    private lateinit var vt:VeritabaniYardimcisi

    private var soruSayac = 0
    private var dogruSayac = 0
    private var yanlisSayac= 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        vt = VeritabaniYardimcisi(this@QuizActivity)

        sorular = LevhalarDao().rasgele5LevhaGetir(vt)

        soruYukle()

        buttonA.setOnClickListener {
            dogruKontrol(buttonA)
            soruSayacKontrol()
        }

        buttonB.setOnClickListener {
            dogruKontrol(buttonB)
            soruSayacKontrol()
        }

        buttonC.setOnClickListener {
            dogruKontrol(buttonC)
            soruSayacKontrol()
        }

        buttonD.setOnClickListener {
            dogruKontrol(buttonD)
            soruSayacKontrol()
        }


    }


    fun soruYukle(){

        textViewSoruSayi.text = "${soruSayac+1}. Soru"

        dogruSoru = sorular.get(soruSayac)

        imageViewLevha.setImageResource(resources.getIdentifier(dogruSoru.levha_resim,"drawable",packageName))

        yanlisSecenekler = LevhalarDao().rasgele3YanlisSecenekGetir(vt,dogruSoru.levha_id)

        tumSecenekler = HashSet()
        tumSecenekler.add(dogruSoru)
        tumSecenekler.add(yanlisSecenekler.get(0))
        tumSecenekler.add(yanlisSecenekler.get(1))
        tumSecenekler.add(yanlisSecenekler.get(2))


        buttonA.text = tumSecenekler.elementAt(0).levha_ad
        buttonB.text = tumSecenekler.elementAt(1).levha_ad
        buttonC.text = tumSecenekler.elementAt(2).levha_ad
        buttonD.text = tumSecenekler.elementAt(3).levha_ad
    }


    fun soruSayacKontrol(){
        soruSayac++

        if(soruSayac != 5){
            soruYukle()
        }else{
            val intent = Intent(this@QuizActivity,ResultActivity::class.java)
            intent.putExtra("dogruSayac",dogruSayac)
            startActivity(intent)
            finish()
        }
    }


    fun dogruKontrol(button: Button){
        val buttonYazi = button.text.toString()
        val dogruCevap = dogruSoru.levha_ad

        if(buttonYazi == dogruCevap){
            dogruSayac++
        }else{
            yanlisSayac++
        }

        textViewDogru.text = "Doğru: ${dogruSayac}"
        textViewYanlis.text = "Yanlış: ${yanlisSayac}"
    }


}