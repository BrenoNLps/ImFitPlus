package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//feito para evitar a repetição de putExtra nas activities
@Parcelize
data class UsuarioCompleto(
    val nome: String,
    val idade: Int,
    val sexo: String,
    val altura: Double,
    val peso: Double,
    val atividade: String,
    val imc: Double = 0.0,
    val categoriaImc: String = "",
    val tmb: Double = 0.0,
    val pesoIdeal: Double = 0.0
) : Parcelable
