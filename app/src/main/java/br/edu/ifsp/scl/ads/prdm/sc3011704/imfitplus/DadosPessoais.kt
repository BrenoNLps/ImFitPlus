package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityDadosPessoaisBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data.DatabaseBuilder
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.model.Usuario
import kotlinx.coroutines.launch

class DadosPessoais : AppCompatActivity() {
    //tela 2
    private lateinit var binding: ActivityDadosPessoaisBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDadosPessoaisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DatabaseBuilder.getInstance(this)

        // Recupera o usuário selecionado no histórico
        val usuarioId = intent.getIntExtra("usuario_id", -1)
        if (usuarioId != -1) {
            lifecycleScope.launch {
                val usuario = db.usuarioDao().getUsuarioById(usuarioId)
                if (usuario != null) {
                    binding.nomeEt.setText(usuario.nome)
                    binding.idadeEt.setText(usuario.idade.toString())

                    if (usuario.sexo == "masculino") {
                        binding.sexoRg.check(R.id.masculino_rb)
                    } else if (usuario.sexo == "feminino") {
                        binding.sexoRg.check(R.id.feminino_rb)
                    }

                    binding.alturaEt.setText(usuario.altura.toString())
                    binding.pesoEt.setText(usuario.peso.toString())

                    // Seleciona a opção correta do Spinner comparando texto
                    val adapter = binding.nivelAtividadeSp.adapter
                    for (i in 0 until adapter.count) {
                        if (adapter.getItem(i).toString() == usuario.atividade) {
                            binding.nivelAtividadeSp.setSelection(i)
                            break
                        }
                    }
                }
            }
        }


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

            val usuario = Usuario(
                nome = nome,
                idade = idade,
                sexo = sexo,
                altura = altura,
                peso = peso,
                atividade = atividade,
                imc = imc
            )

            val resultadoIMC = Intent(this, ResultadoIMC::class.java)
            resultadoIMC.putExtra("usuario", usuario)
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