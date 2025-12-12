package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.mapper

import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data.UsuarioEntity
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.model.Usuario

fun Usuario.toEntity(): UsuarioEntity {
    return UsuarioEntity(
        id = this.id,
        nome = nome,
        idade = idade,
        sexo = sexo,
        altura = altura,
        peso = peso,
        atividade = atividade,
        imc = imc,
        categoriaImc = categoriaImc,
        tmb = tmb,
        pesoIdeal = pesoIdeal
    )
}

fun UsuarioEntity.toModel(): Usuario {
    return Usuario(
        id = id,
        nome = nome,
        idade = idade,
        sexo = sexo,
        altura = altura,
        peso = peso,
        atividade = atividade,
        imc = imc,
        categoriaImc = categoriaImc,
        tmb = tmb,
        pesoIdeal = pesoIdeal
    )
}