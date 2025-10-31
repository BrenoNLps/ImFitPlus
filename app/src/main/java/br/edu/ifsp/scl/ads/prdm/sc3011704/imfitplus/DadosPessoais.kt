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
            val nome         = binding.nomeEt.text.toString()
            val idadeString  = binding.idadeEt.text.toString()
            val alturaString = binding.alturaEt.text.toString()
            val pesoString   = binding.pesoEt.text.toString()


            if (nome.isBlank()   || idadeString.isBlank()  || alturaString.isBlank() || pesoString.isBlank()){
                Toast.makeText(
                    this,"Preencha todos os campos!",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val idade  = idadeString.toInt()
            val altura = validarAltura(alturaString)
            val peso   = validarPeso  (pesoString)
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

    private fun validarAltura(texto: String): Double {
        return try {
            val valor = texto.toDouble()
            if (texto.contains(".") || valor in 0.5..2.5) valor else valor / 100
        } catch (e: NumberFormatException) {
            0.0
        }

    }

    private fun validarPeso(texto: String): Double {
        return try {
            val valor = texto.toDouble()
            if (texto.contains(".") || valor in 30.0..300.0) valor else valor / 100
        } catch (e: NumberFormatException) {
            0.0
        }

    }

}