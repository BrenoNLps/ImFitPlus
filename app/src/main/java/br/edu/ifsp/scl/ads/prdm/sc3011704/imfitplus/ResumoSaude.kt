package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityResumoSaudeBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.model.UsuarioCompleto

class ResumoSaude : AppCompatActivity() {
    //tela 6
    private lateinit var binding: ActivityResumoSaudeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumoSaudeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getParcelableExtra<UsuarioCompleto>("usuario")!!

        // Calculo de agua : 350ml por quilograma(peso corporal),resultado em litros
        val recomendacaoAgua = (usuario.peso* 350)/10000

        binding.resultadoFinalTv.text="Nome: ${usuario.nome} \nimc: ${usuario.imc} \ncategoria: ${usuario.categoriaImc} \npeso: ${usuario.peso} \npeso Ideal: ${usuario.pesoIdeal} \ngasto calorico: ${usuario.tmb} \nRecomendacao de agua: $recomendacaoAgua Litros \n"

        binding.voltarBt.setOnClickListener {
            finish()
        }
    }
}