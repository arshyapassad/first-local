package com.example.localproject.ui.home

import android.os.Bundle
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentHome : Fragment(), AddTaskDialog.AddTask, AdapterHome.ClickTask {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val adapterHome = AdapterHome(this)
    private val viewModel: HomeViewModel by viewModels()
    private val dialogAddTaskDialog = AddTaskDialog(this)
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
            dialogAddTaskDialog.show(parentFragmentManager, null)
        }
    }

    override fun addTask(task: Task) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.addTask(task)
            delay(1000)
            getTasks()
        }
    }

    override fun update(task: Task) {
        viewModel.updateTask(task)
    }

    override fun removeTask(task: Task) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.removeTask(task)
            delay(1000)
            getTasks()
        }
    }

    override fun getTask(task: Task) {
        val bundle = Bundle().apply {
            putParcelable("task", task)
        }
        dialogAddTaskDialog.arguments = bundle
        dialogAddTaskDialog.show(childFragmentManager, null)
    }
}