package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityDadosPessoaisBinding

class DadosPessoais : AppCompatActivity() {
    //tela 2
    private lateinit var binding: ActivityDadosPessoaisBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDadosPessoaisBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.enviarBt.setOnClickListener {
            val nome   = binding.nomeEt.text.toString()
            val idade  = binding.idadeEt.text.toString().toIntOrNull()
            val altura = validarAltura(binding.alturaEt.text.toString())
            val peso   = validarPeso(binding.pesoEt.text.toString())
            if (nome.isBlank() || idade == null || altura == null || peso == null) {
                Toast.makeText(
                    this,
                    "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sexo = when (binding.sexoRg.checkedRadioButtonId){
                R.id.masculino_rb -> "masculino"
                R.id.feminino_rb  -> "feminino"
                else -> ""
            }
            val atividade = binding.nivelAtividadeSp.selectedItem.toString()
            val imc = peso/ (altura*altura)

            val resultadoIMC = Intent(this, ResultadoIMC::class.java)
            resultadoIMC.putExtra("nome"     ,nome)
            resultadoIMC.putExtra("imc"      ,imc)
            resultadoIMC.putExtra("sexo"     ,sexo)
            resultadoIMC.putExtra("idade"    ,idade)
            resultadoIMC.putExtra("peso"     ,peso)
            resultadoIMC.putExtra("altura"   ,altura)
            resultadoIMC.putExtra("atividade",atividade)
            startActivity(resultadoIMC)
        }

    }

    private fun validarAltura(texto: String): Double? {
        return try {
            val valor = texto.toDouble()
            if (texto.contains(".") || valor in 0.5..2.5) valor else valor / 100
        } catch (e: NumberFormatException) {
            null
        }

    }
    private fun validarPeso(texto: String): Double? {
        return try {
            val valor = texto.toDouble()
            if (texto.contains(".") || valor in 30.0..300.0) valor else valor / 100
        } catch (e: NumberFormatException) {
            null
        }

    }


}