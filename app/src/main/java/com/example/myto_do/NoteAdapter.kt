package com.example.myto_do

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private var notes :List<Note>, context: Context):RecyclerView.Adapter<NoteAdapter.TaskViewHolder>() {


     private val db:NoteDatabaseHelper = NoteDatabaseHelper(context)


    class TaskViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val titleTextView : TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView : TextView = itemView.findViewById(R.id.descriptionTextView)
        val dateTextView : TextView = itemView.findViewById(R.id.dateTextView)
        val timeTextView : TextView = itemView.findViewById(R.id.timeTextView)
        val updatebtn : ImageView = itemView.findViewById(R.id.updatebutton)
        val deletebutton : ImageView = itemView.findViewById(R.id.deletebutton)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return TaskViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  notes.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
           val task = notes[position]
           holder.titleTextView.text = task.title
           holder.descriptionTextView.text = task.description
           holder.dateTextView.text = task.date
           holder.timeTextView.text = task.time

        holder.updatebtn.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateNoteActivity::class.java).apply{
                putExtra("task_id",task.id)
            }

            holder.itemView.context.startActivity(inte
        }

        holder.deletebutton.setOnClickListener{
            db.deleteTast(task.id)
            refreshdata(db.getAllTasks())
            Toast.makeText(holder.itemView.context, "Note Deleted successfully", Toast.LENGTH_LONG).show()
        }


    }

    fun refreshdata(newNotes :List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }
}