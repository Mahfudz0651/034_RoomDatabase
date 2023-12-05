package com.example.roomsiswa_aplikasisiswa.repository

import android.content.Context
import com.example.roomsiswa_aplikasisiswa.data.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

class ContainerdataApp(private val context: Context): ContainerApp{
    override val repositoriSiswa: RepositoriSiswa  by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}