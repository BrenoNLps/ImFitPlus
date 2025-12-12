package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.databinding.ActivityHistoricoBinding
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.adapter.UsuarioAdapter
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data.DatabaseBuilder
import kotlinx.coroutines.launch

class Historico : AppCompatActivity() {
    private lateinit var binding: ActivityHistoricoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHistoricoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DatabaseBuilder.getInstance(this)

        lifecycleScope.launch {
            val listaUsuarios = db.usuarioDao().historicoCompleto()
            binding.historicoRv.layoutManager = LinearLayoutManager(this@Historico)
            binding.historicoRv.adapter = UsuarioAdapter(listaUsuarios)
        }

        binding.voltarBt.setOnClickListener {
            finish()
        }
    }
}