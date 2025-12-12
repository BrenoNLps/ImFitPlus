package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityResultadoImcBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.model.UsuarioCompleto

class ResultadoIMC : AppCompatActivity() {
    //tela 3
    private lateinit var binding: ActivityResultadoImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultadoImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getParcelableExtra<UsuarioCompleto>("usuario")!!

        val categoria = when{
            usuario.imc < 18.5 -> "Abaixo do peso"
            usuario.imc < 25.0 -> "Peso normal"
            usuario.imc < 30.0 -> "Sobrepeso"
            else-> "Obesidade"
        }

        binding.nomeTv.text="Nome: ${usuario.nome}"
        binding.imcTv.text = "IMC: ${usuario.imc}"
        binding.categoriaTv.text = "Categoria: $categoria"

        binding.calcularBt.setOnClickListener {
            val GastoCalorico = Intent(this, GastoCalorico::class.java)
            val usuarioAtualizado = usuario.copy(categoriaImc = categoria)
            GastoCalorico.putExtra("usuario", usuarioAtualizado)
            startActivity(GastoCalorico)
        }

        binding.voltarBt.setOnClickListener {
            finish()
        }
    }
}