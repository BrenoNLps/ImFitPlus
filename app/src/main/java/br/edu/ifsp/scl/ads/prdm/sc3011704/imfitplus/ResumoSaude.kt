package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data.DatabaseBuilder
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityResumoSaudeBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.mapper.toEntity
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.model.Usuario
import kotlinx.coroutines.launch

class ResumoSaude : AppCompatActivity() {
    //tela 6
    private lateinit var binding: ActivityResumoSaudeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumoSaudeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getParcelableExtra<Usuario>("usuario") ?: return

        // Calculo de agua : 350ml por quilograma(peso corporal),resultado em litros
        val recomendacaoAgua = (usuario.peso* 350)/10000

        binding.resultadoFinalTv.text = """
Nome: ${usuario.nome}
IMC: %.2f
Categoria: ${usuario.categoriaImc}
Peso: %.1f kg
Peso Ideal: %.1f kg
Gasto Calórico (TMB): %.2f kcal
Recomendação de água: %.2f L
""".format(
            usuario.imc,
            usuario.peso,
            usuario.pesoIdeal,
            usuario.tmb,
            recomendacaoAgua
        )


        //salva no banco de dados
        val db = DatabaseBuilder.getInstance(this)
        val usuarioEntity = usuario.toEntity()

        lifecycleScope.launch {
            db.usuarioDao().insert(usuarioEntity)
        }


        binding.voltarBt.setOnClickListener {
            finish()
        }
    }
}