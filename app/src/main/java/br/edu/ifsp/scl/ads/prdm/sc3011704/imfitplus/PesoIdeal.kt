package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityPesoIdealBinding

class PesoIdeal : AppCompatActivity() {
    //tela 5
    private lateinit var binding: ActivityPesoIdealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesoIdealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imc = intent.getDoubleExtra("imc",0.0)
        val categoria = intent.getStringExtra("categoria")
        val gastoCalorico = intent.getStringExtra("gastoCalorico")
        val nome = intent.getStringExtra("nome")
        val peso = intent.getDoubleExtra("peso", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)

        val pesoIdeal = 22 * (altura * altura)
        val diferenca = peso - pesoIdeal

        val pesoIdealFormatado = String.format("%.2f", pesoIdeal)
        val diferencaFormatada = String.format("%.2f", kotlin.math.abs(diferenca))

        val mensagem = when {
            diferenca > 0 -> "Você está acima do peso ideal em $diferencaFormatada kg"
            diferenca < 0 -> "Você está abaixo do peso ideal em $diferencaFormatada kg"
            else -> "Você está no peso ideal!"
        }

        binding.resultadoTv.text =
            " $nome,\n Seu peso atual é : ${String.format("%.2f", peso)} kg \n Seu peso ideal é : $pesoIdealFormatado kg \n $mensagem".trimIndent()

        binding.resumoSaudeBt.setOnClickListener{
            val ResumoFinal = Intent(this, ResumoSaude::class.java)

            ResumoFinal.putExtra("nome"     , nome)
            ResumoFinal.putExtra("imc"      , imc)
            ResumoFinal.putExtra("peso"     , peso)
            ResumoFinal.putExtra("categoria"     , categoria)
            ResumoFinal.putExtra("pesoIdeal"     , pesoIdealFormatado)//////////////////
            ResumoFinal.putExtra("gastoCalorico"     , gastoCalorico)////////////////////////


            startActivity(ResumoFinal)

        }
        binding.voltarBt.setOnClickListener {
            finish()
        }


    }
}