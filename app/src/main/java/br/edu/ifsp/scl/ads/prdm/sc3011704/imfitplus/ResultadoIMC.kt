package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityDadosPessoaisBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityResultadoImcBinding

class ResultadoIMC : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityResultadoImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}