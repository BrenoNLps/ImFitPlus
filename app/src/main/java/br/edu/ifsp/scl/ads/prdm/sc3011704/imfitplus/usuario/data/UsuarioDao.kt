package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setUsuario(usuario: UsuarioEntity)

    @Query("SELECT * FROM usuario ORDER BY dataHora DESC")
    suspend fun getUsuarios(): List<UsuarioEntity>

    @Query("SELECT * FROM usuario WHERE nome = :nome")
    suspend fun getUsuarioByNome(nome: String): UsuarioEntity?

    @Query("SELECT * FROM usuario WHERE id = :id")
    suspend fun getUsuarioById(id: Int): UsuarioEntity?

    @Update
    suspend fun updateUsuario(usuario: UsuarioEntity)

    @Query("SELECT * FROM usuario WHERE nome = :nome ORDER BY dataHora DESC")
    suspend fun getUsuarioByName(nome: String): List<UsuarioEntity>

}