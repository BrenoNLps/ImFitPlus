package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val idade: Int,
    val sexo: String,
    val altura: Double,
    val peso: Double,
    val atividade: String,
    val imc: Double,
    val categoriaImc: String,
    val tmb: Double,
    val pesoIdeal: Double,
    val dataHora: Long = System.currentTimeMillis()
)