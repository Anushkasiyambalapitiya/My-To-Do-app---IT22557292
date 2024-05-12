package com.example.myto_do

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DisplayNote:AppCompatActivity() {

       private lateinit var db : NoteDatabaseHelper
       private lateinit var noteAdapter : NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_note)

        val addbtn :Button = findViewById<Button>(R.id.addbtn)

        db = NoteDatabaseHelper(this)
        noteAdapter = NoteAdapter(db.getAllTasks(),this)

        val displaytaskView : RecyclerView = findViewById(R.id.taskrecyclerview)
        displaytaskView.layoutManager = LinearLayoutManager(this)

        displaytaskView.adapter = noteAdapter;


        addbtn.setOnClickListener{
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }


    }

 override   fun onResume() {
        super.onResume()
     noteAdapter. refreshdata(db.getAllTasks())
    }
}