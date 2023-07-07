package com.example.localproject.ui.home

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.localproject.data.modle.Task
import com.example.localproject.databinding.AddTaskDialogBinding

class AddTaskDialog(val addTask: (Task) -> Unit) :
    DialogFragment() {
    var _binding: AddTaskDialogBinding? = null
    val binding get() = _binding!!
    var task: Task? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
//        arguments?.let {
//            task = it.getParcelable("task")
//        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
        _binding = AddTaskDialogBinding.inflate(LayoutInflater.from(requireContext()))
        setTask()
        dialog.setView(binding.root)
        onClick()
        return dialog.create()
    }

    private fun setTask() {
        task?.let {
            binding.etAddTaskDialogNameTask.setText(it.nameTask)
        }
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
        val task = if (task != null) {
            val nameTask = binding.etAddTaskDialogNameTask.text.toString()
            task.apply { this?.nameTask = nameTask }
        } else {
            val nameTask = binding.etAddTaskDialogNameTask.text.toString()
            Task(nameTask = nameTask, isChecked = false)
        }

        task?.let { addTask(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
//        task = null
//        arguments = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}