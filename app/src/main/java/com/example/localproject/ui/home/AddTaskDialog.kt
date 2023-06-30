package com.example.localproject.ui.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.localproject.data.modle.Task
import com.example.localproject.databinding.AddTaskDialogBinding

class AddTaskDialog(val addTask: AddTask) : DialogFragment() {
    var _binding: AddTaskDialogBinding? = null
    val binding get() = _binding!!
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
        _binding = AddTaskDialogBinding.inflate(LayoutInflater.from(requireContext()))
        dialog.setView(binding.root)
        onClick()
        return dialog.create()
    }

    private fun onClick() {
        binding.btnDialogAddTaskOk.setOnClickListener {
            createTask()
            dismiss()
        }
        binding.btnDialogAddTaskCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun createTask() {
        val nameTask = binding.etAddTaskDialogNameTask.text.toString()
        val task = Task(nameTask = nameTask, isChecked = false)
        addTask.addTask(task)
    }

    interface AddTask {
        fun addTask(task: Task)
    }
}