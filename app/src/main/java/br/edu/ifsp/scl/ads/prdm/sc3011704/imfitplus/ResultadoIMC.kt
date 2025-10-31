package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityDadosPessoaisBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityResultadoImcBinding

class ResultadoIMC : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultadoImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sexo      = intent.getStringExtra("sexo")
        val idade     = intent.getIntExtra("idade", 0)
        val peso      = intent.getDoubleExtra("peso", 0.0)
        val altura    = intent.getDoubleExtra("altura", 0.0)
        val atividade = intent.getStringExtra("atividade")

        val nome      = intent.getStringExtra("nome")
        val imc       = intent.getDoubleExtra("imc", 0.0)

        val categoria = when{
            imc < 18.5 -> "Abaixo do peso"
            imc < 25.0 -> "Normal"
            imc < 30.0 -> "Sobrepeso"
            else-> "Obesidade"
        }

        binding.nomeTv.text="Nome: $nome"
        binding.imcTv.text = "IMC: $imc"
        binding.categoriaTv.text = "Categoria: $categoria"

        binding.calcularBt.setOnClickListener {
            val GastoCalorico = Intent(this, GastoCalorico::class.java)

            GastoCalorico.putExtra("nome"     , nome)
            GastoCalorico.putExtra("sexo"     , sexo)
            GastoCalorico.putExtra("idade"    , idade)
            GastoCalorico.putExtra("peso"     , peso)
            GastoCalorico.putExtra("altura"   , altura)
            GastoCalorico.putExtra("atividade", atividade)
            startActivity(GastoCalorico)
        }

        binding.voltarBt.setOnClickListener {
            finish()
        }
    }
}