package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityGastoCaloricoBinding

class Historico : AppCompatActivity() {
    private lateinit var binding: ActivityGastoCaloricoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGastoCaloricoBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}