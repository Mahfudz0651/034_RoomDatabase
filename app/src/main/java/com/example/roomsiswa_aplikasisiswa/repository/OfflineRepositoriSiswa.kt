package com.example.roomsiswa_aplikasisiswa.repository

import com.example.roomsiswa_aplikasisiswa.data.Siswa
import com.example.roomsiswa_aplikasisiswa.data.SiswaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriSiswa(private val siswaDao: SiswaDao):RepositoriSiswa {
    override fun getAllsiswaStream(): Flow<List<Siswa>> = siswaDao.getALLSiswa()

    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)

    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)

    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)


}