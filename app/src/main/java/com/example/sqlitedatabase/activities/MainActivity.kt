package com.example.sqlitedatabase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sqlitedatabase.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
//        button_create.setOnClickListener(this)
//        button_delete.setOnClickListener(this)
//        button_read.setOnClickListener(this)
//        button_update.setOnClickListener(this)

        startActivity(Intent(this, EmployeeListActivity::class.java))


    }

//    override fun onClick(v: View) {
//        when(v.id) {
//            R.id.button_create -> startActivity(Intent(this, CreateActivity::class.java))
//            R.id.button_update -> startActivity(Intent(this, UpdateActivity::class.java))
//            R.id.button_delete -> startActivity(Intent(this, DeleteActivity::class.java))
//        }

}