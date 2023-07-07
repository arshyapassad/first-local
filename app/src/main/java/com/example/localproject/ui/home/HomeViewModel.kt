package com.example.localproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.localproject.data.modle.Task
import com.example.localproject.data.repository.homeRepository.HomeRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {

    fun addTask(task: Task): Int {
        viewModelScope.launch {
            homeRepository.addTask(task)
        }
        return 0
    }

    fun getTasks(): LiveData<List<Task>> = liveData {
        emitSource(homeRepository.getTasks().asLiveData())
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