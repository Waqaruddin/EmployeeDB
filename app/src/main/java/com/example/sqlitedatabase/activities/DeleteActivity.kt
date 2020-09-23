package com.example.sqlitedatabase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitedatabase.R
import com.example.sqlitedatabase.database.DBHelper
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        dbHelper = DBHelper(this)
        init()
    }

    private fun init() {
        button_delete.setOnClickListener {
            var id = edit_text_id.text.toString().toInt()

            dbHelper.deleteEmployee(id)
            Toast.makeText(applicationContext, "Deleted record", Toast.LENGTH_SHORT).show()

        }
    }
}