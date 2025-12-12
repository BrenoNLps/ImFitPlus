package br.edu.ifsp.scl.ads.prdm.sc3011704.imfitplus.usuario.data

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "imfitplus_db"
            ).build()
        }
        return INSTANCE!!
    }
}