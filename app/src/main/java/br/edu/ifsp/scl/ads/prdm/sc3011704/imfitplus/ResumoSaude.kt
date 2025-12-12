package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityResumoSaudeBinding

class ResumoSaude : AppCompatActivity() {
    //tela 6
    private lateinit var binding: ActivityResumoSaudeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumoSaudeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*informacoes :
        nome
        imc
        categoria imc
        peso
        peso ideal
        gasto calorico
        recomendacao de ingestao de agua

        Calculo de agua : 350ml por quilograma(peso corporal),resultado em litros
         */

        val nome      = intent.getStringExtra("nome")
        val imc       = intent.getDoubleExtra("imc", 0.0)
        val peso      = intent.getDoubleExtra("peso", 0.0)
        val categoria = intent.getStringExtra("categoria")
        val pesoIdeal      = intent.getStringExtra("pesoIdeal")
        val gastoCalorico  = intent.getStringExtra("gastoCalorico")

        val recomendacaoAgua = (peso* 350)/10000

        binding.resultadoFinalTv.text="Nome: $nome \nimc: $imc \ncategoria: $categoria \npeso: $peso \npeso Ideal: $pesoIdeal \ngasto calorico: $gastoCalorico \nRecomendacao de agua: $recomendacaoAgua Litros \n"

        binding.voltarBt.setOnClickListener {
            finish()
        }
    }
}