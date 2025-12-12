package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.data

import androidx.room.Database
import androidx.room.RoomDatabase


// lista de tabelas
@Database(entities = [UsuarioEntity::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}
