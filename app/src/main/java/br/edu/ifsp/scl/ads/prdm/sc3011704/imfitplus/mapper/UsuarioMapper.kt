package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.mapper

import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.data.UsuarioEntity
import br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.model.UsuarioCompleto

fun UsuarioCompleto.toEntity(): UsuarioEntity {
    return UsuarioEntity(
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

fun UsuarioEntity.toModel(): UsuarioCompleto {
    return UsuarioCompleto(
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