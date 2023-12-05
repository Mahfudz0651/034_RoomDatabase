package com.example.roomsiswa_aplikasisiswa.repository

import com.example.roomsiswa_aplikasisiswa.data.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllsiswaStream(): Flow<List<Siswa>>

    fun getSiswaStream(id: Int): Flow<Siswa?>

    suspend fun insertSiswa(siswa: Siswa)

    suspend fun deleteSiswa(siswa: Siswa)

    suspend fun updateSiswa(siswa: Siswa)
}