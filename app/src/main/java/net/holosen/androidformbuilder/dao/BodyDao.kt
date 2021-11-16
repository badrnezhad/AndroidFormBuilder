package net.holosen.androidformbuilder.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import net.holosen.androidformbuilder.models.Body

@Dao
interface BodyDao {
    @Insert
    suspend fun insert(body: Body)

    @Update
    suspend fun update(body: Body)

    @Delete
    suspend fun delete(body: Body)

    @Query("SELECT * FROM body order by id asc")
    fun getAll(): LiveData<List<Body>>

    @Query("SELECT * FROM body where id = :id limit 1")
    suspend fun getById(id: Long): Body
}