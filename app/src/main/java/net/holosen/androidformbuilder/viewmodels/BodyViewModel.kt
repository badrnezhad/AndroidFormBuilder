package net.holosen.androidformbuilder.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.holosen.androidformbuilder.models.Body
import net.holosen.androidformbuilder.repository.BodyRepository

class BodyViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: BodyRepository = BodyRepository(application)
    var dataList = mutableStateOf<List<Body>>(listOf())

    fun insert(body: Body) {
        viewModelScope.launch { repository.insert(body) }
    }

    fun update(body: Body) {
        if (body.id!! <= 0) return
        viewModelScope.launch { repository.update(body) }
    }

    fun delete(body: Body) {
        if (body.id!! <= 0) return
        viewModelScope.launch { repository.delete(body) }
    }

    fun getAllData(): LiveData<List<Body>> {
        return repository.getAllBodies()
    }

    fun getById(id: Long): Body? {
        return repository.getById(id)
    }
}