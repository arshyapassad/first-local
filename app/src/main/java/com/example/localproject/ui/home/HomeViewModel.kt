package com.example.localproject.ui.home

import androidx.lifecycle.ViewModel
import com.example.localproject.data.modle.Task
import com.example.localproject.data.repository.homeRepository.HomeRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val homeRepository: HomeRepository):ViewModel() {
    fun addTask(task: Task){
        homeRepository.addTask(task)
    }

    fun getTasks():List<Task>{
        return homeRepository.getTasks()
    }

    fun updateTask(task: Task){
        homeRepository.updateTask(task)
    }

    fun removeTask(task: Task){
        homeRepository.removeTask(task)
    }
}