package net.holosen.androidformbuilder.repository

import android.app.Application
import androidx.lifecycle.LiveData
import net.holosen.androidformbuilder.dao.BodyDao
import net.holosen.androidformbuilder.database.AFBDataBase
import net.holosen.androidformbuilder.models.Body

class BodyRepository(application: Application) {

    private var bodyDao: BodyDao
    private var allBodies: LiveData<List<Body>>

    init {
        val database = AFBDataBase.getInstance(application)
        bodyDao = database.bodyDao()
        allBodies = bodyDao.getAll()
    }

    suspend fun insert(body: Body) {
        bodyDao.insert(body)
    }

    suspend fun update(body: Body) {
        bodyDao.update(body)
    }

    suspend fun delete(body: Body) {
        bodyDao.delete(body)
    }

    fun getAllBodies(): LiveData<List<Body>> {
        return allBodies
    }

    fun getById(id: Long): Body? {
        return allBodies.value!!.firstOrNull { x ->
            x.id == id
        }
    }
}