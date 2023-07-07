package com.example.localproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.localproject.data.modle.Task
import com.example.localproject.databinding.AdapterHomeBinding

class AdapterHome(
    val updateTask: (Task) -> Unit,
    val removeTask: (Task) -> Unit,
    val getTask: (Task) -> Unit
) :
    RecyclerView.Adapter<AdapterHome.ViewHolder>() {

    var tasks = ArrayList<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    inner class ViewHolder(val binding: AdapterHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.checkBox.text = task.nameTask
            binding.checkBox.isChecked = task.isChecked
            binding.checkBox.setOnLongClickListener {
                removeTask(task)
                return@setOnLongClickListener true
            }
            itemView.setOnClickListener {
                getTask(task)
            }
            binding.checkBox.setOnClickListener {
                updateTask(task.apply { isChecked = !isChecked })
            }
        }
    }
}