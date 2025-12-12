package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityGastoCaloricoBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityMainBinding

class GastoCalorico : AppCompatActivity() {
    //tela 4
    private lateinit var binding: ActivityGastoCaloricoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGastoCaloricoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome   = intent.getStringExtra("nome")
        val categoria = intent.getStringExtra("categoria")
        val sexo   = intent.getStringExtra("sexo")
        val idade  = intent.getIntExtra   ("idade" , 0  )
        val peso   = intent.getDoubleExtra("peso"  , 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)
        val imc    = intent.getDoubleExtra("imc",  0.0)

        val tmb = when (sexo?.lowercase()) {
            "masculino" -> 66  + (13.7 * peso) + (5 * altura * 100  ) - (6.8 * idade)
            "feminino"  -> 655 + (9.6 * peso ) + (1.8 * altura * 100) - (4.7 * idade)
            else -> 0.0
        }

        val gastoCalorico = String.format("%.2f", tmb)

        binding.resultadoTv.text = "$nome, \nSua Taxa Metabólica Basal é de $gastoCalorico kcal."

        binding.proximoBt.setOnClickListener {
            val pesoIdeal = Intent(this, PesoIdeal::class.java)
            pesoIdeal.putExtra("nome", nome)
            pesoIdeal.putExtra("imc"      , imc)
            pesoIdeal.putExtra("peso", peso)
            pesoIdeal.putExtra("altura", altura)
            pesoIdeal.putExtra("categoria", categoria)
            pesoIdeal.putExtra("gastoCalorico", gastoCalorico)
            startActivity(pesoIdeal)
        }

        binding.voltarBt.setOnClickListener { finish() }



    }
}