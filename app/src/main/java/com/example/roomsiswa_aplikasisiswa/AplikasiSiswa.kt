package com.example.roomsiswa_aplikasisiswa

import android.app.Application
import com.example.roomsiswa_aplikasisiswa.data.DatabaseSiswa
import com.example.roomsiswa_aplikasisiswa.repository.ContainerApp
import com.example.roomsiswa_aplikasisiswa.repository.ContainerdataApp

class AplikasiSiswa : Application() {


    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerdataApp(this)
    }
}