package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityGastoCaloricoBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityMainBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.model.UsuarioCompleto

class GastoCalorico : AppCompatActivity() {
    //tela 4
    private lateinit var binding: ActivityGastoCaloricoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGastoCaloricoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getParcelableExtra<UsuarioCompleto>("usuario")!!

        val tmb = when (usuario.sexo?.lowercase()) {
            "masculino" -> 66  + (13.7 * usuario.peso) + (5 * usuario.altura * 100  ) - (6.8 * usuario.idade)
            "feminino"  -> 655 + (9.6 * usuario.peso ) + (1.8 * usuario.altura * 100) - (4.7 * usuario.idade)
            else -> 0.0
        }

        val gastoCalorico = (String.format("%.2f", tmb)).toDouble()

        binding.resultadoTv.text = "${usuario.nome}, \nSua Taxa Metabólica Basal é de $gastoCalorico kcal."

        binding.proximoBt.setOnClickListener {
            val pesoIdeal = Intent(this, PesoIdeal::class.java)
            val usuarioAtualizado = usuario.copy(tmb = gastoCalorico)
            pesoIdeal.putExtra("usuario", usuarioAtualizado)
            startActivity(pesoIdeal)
        }

        binding.voltarBt.setOnClickListener { finish() }



    }
}