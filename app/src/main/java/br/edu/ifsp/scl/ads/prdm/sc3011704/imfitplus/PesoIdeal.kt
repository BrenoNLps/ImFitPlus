package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityPesoIdealBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.model.Usuario

class PesoIdeal : AppCompatActivity() {
    //tela 5
    private lateinit var binding: ActivityPesoIdealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesoIdealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getParcelableExtra<Usuario>("usuario")!!

        val pesoIdeal = 22 * (usuario.altura * usuario.altura)
        val diferenca = usuario.peso - pesoIdeal

        val pesoIdealFormatado = String.format("%.2f", pesoIdeal)
        val diferencaFormatada = String.format("%.2f", kotlin.math.abs(diferenca))

        val mensagem = when {
            diferenca > 0 -> "Você está acima do peso ideal em $diferencaFormatada kg"
            diferenca < 0 -> "Você está abaixo do peso ideal em $diferencaFormatada kg"
            else -> "Você está no peso ideal!"
        }

        binding.resultadoTv.text =
            " ${usuario.nome},\n Seu peso atual é : ${String.format("%.2f", usuario.peso)} kg \n Seu peso ideal é : $pesoIdealFormatado kg \n $mensagem".trimIndent()

        binding.resumoSaudeBt.setOnClickListener{
            val resumoFinal = Intent(this, ResumoSaude::class.java)
            val usuarioAtualizado = usuario.copy(pesoIdeal = pesoIdeal)
            resumoFinal.putExtra("usuario", usuarioAtualizado)
            startActivity(resumoFinal)

        }
        binding.voltarBt.setOnClickListener {
            finish()
        }


    }
}