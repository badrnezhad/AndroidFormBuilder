package net.holosen.androidformbuilder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.holosen.androidformbuilder.dao.BodyDao
import net.holosen.androidformbuilder.models.Body

@Database(entities = [Body::class], version = 1)
abstract class AFBDataBase : RoomDatabase() {

    abstract fun bodyDao(): BodyDao

    companion object {
        private var instance: AFBDataBase? = null
        fun getInstance(context: Context): AFBDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AFBDataBase::class.java, "AFB.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as AFBDataBase
        }
    }
}