package com.example.sqlitedatabase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitedatabase.R
import com.example.sqlitedatabase.database.DBHelper
import com.example.sqlitedatabase.models.Employee
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        dbHelper = DBHelper(this)
        var id = intent.getIntExtra("key",1)
        text_view_id.text = id.toString()
        init()
    }

    private fun init() {
        button_update.setOnClickListener {
            var id = text_view_id.text.toString().toInt()
            var name = edit_text_name.text.toString()
            var email = edit_text_email.text.toString()

            var employee = Employee(id, name, email)
            dbHelper.updateEmployee(employee)
            Toast.makeText(applicationContext, "Updated record", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext, EmployeeListActivity::class.java))

        }
    }
}