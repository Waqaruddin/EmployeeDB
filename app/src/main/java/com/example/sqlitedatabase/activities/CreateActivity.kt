package com.example.sqlitedatabase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitedatabase.R
import com.example.sqlitedatabase.database.DBHelper
import com.example.sqlitedatabase.models.Employee
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_main.button_create

class CreateActivity : AppCompatActivity() {

    lateinit var dbhelper:DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        dbhelper = DBHelper(this)
        init()
    }

    private fun init() {
        button_create.setOnClickListener {
            var id = edit_text_id.text.toString().toInt()
            var name = edit_text_name.text.toString()
            var email = edit_text_email.text.toString()

            var employee = Employee(id, name , email)

            dbhelper.addEmployee(employee)
            Toast.makeText(applicationContext, "Record added", Toast.LENGTH_SHORT).show()
        }
    }
}