package com.example.localproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.localproject.data.modle.Task
import com.example.localproject.databinding.AdapterHomeBinding

class AdapterHome(val clickTask: ClickTask) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {

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
                clickTask.removeTask(task)
                return@setOnLongClickListener true
            }
            itemView.setOnClickListener {
                clickTask.getTask(task)
            }
            binding.checkBox.setOnClickListener {
                clickTask.update(task.apply { isChecked = !isChecked })
            }
        }
    }

    interface ClickTask {
        fun update(task: Task)

        fun removeTask(task: Task)

        fun getTask(task: Task)
    }
}