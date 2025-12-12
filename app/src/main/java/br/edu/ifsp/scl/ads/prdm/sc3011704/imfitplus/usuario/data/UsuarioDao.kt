package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insert(usuario: UsuarioEntity)

    @Query("SELECT * FROM usuario WHERE nome = :nome ORDER BY dataHora DESC")
    suspend fun historicoPorNomeUsuario(nome: String): List<UsuarioEntity>

    @Query("SELECT * FROM usuario ORDER BY dataHora DESC")
    suspend fun historicoCompleto(): List<UsuarioEntity>

    @Query("SELECT * FROM usuario WHERE nome = :nome")
    suspend fun getUsuarioByNome(nome: String): UsuarioEntity?

}