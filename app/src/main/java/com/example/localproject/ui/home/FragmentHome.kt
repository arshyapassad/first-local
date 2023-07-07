package com.example.localproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.localproject.data.modle.Task
import com.example.localproject.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val adapterHome = AdapterHome(updateTask = {
        update(it)
    }, removeTask = {
        removeTask(it)
    }, getTask = {
        getTask(it)
    })
    private val viewModel: HomeViewModel by viewModels()
    private val dialogAddTaskDialog = AddTaskDialog(addTask = {
        addTask(it)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        setRecyclerView()
        getTasks()
    }

    private fun getTasks() {
        viewModel.getTasks().observe(viewLifecycleOwner) {
            it?.let {
                adapterHome.tasks = it as ArrayList<Task>
            }
        }
    }

    private fun setRecyclerView() {
        binding.rvFragmentHomeListTasks.apply {
            adapter = adapterHome
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    private fun onClick() {
        binding.fabHomeFragmentAddTask.setOnClickListener {
            dialogAddTaskDialog.show(childFragmentManager, null)
        }
    }

    private fun addTask(task: Task) {
        viewModel.addTask(task)
    }

    private fun update(task: Task) {
        viewModel.updateTask(task)
    }

    private fun removeTask(task: Task) {
        viewModel.removeTask(task)
    }

    private fun getTask(task: Task) {
        val bundle = Bundle().apply {
            putParcelable("task", task)
        }
        dialogAddTaskDialog.arguments = bundle
        dialogAddTaskDialog.show(childFragmentManager, null)
    }
}