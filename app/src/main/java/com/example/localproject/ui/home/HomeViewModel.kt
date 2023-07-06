package com.example.localproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.localproject.data.modle.Task
import com.example.localproject.data.repository.homeRepository.HomeRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {
    val live = MutableLiveData<List<Task>>()

    init {
        rahim()
    }
    fun addTask(task: Task) {
        viewModelScope.launch {
            homeRepository.addTask(task)
        }
    }

    //    fun getTasks():List<Task>{
//        return homeRepository.getTasks()
//    }
    fun getTasks(): LiveData<List<Task>> = liveData {
        val data = homeRepository.getTasks() // loadUser is a suspend function.
        emit(data)
    }
    fun rahim(){
        viewModelScope.launch {
            live.value = homeRepository.getTasks()
        }
    }
    fun updateTask(task: Task) {
        viewModelScope.launch {
            homeRepository.updateTask(task)
        }
    }

    fun removeTask(task: Task) {
        viewModelScope.launch {
            homeRepository.removeTask(task)
        }
    }
}