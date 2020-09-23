package com.example.sqlitedatabase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlitedatabase.R
import com.example.sqlitedatabase.adapter.AdapterEmployee
import com.example.sqlitedatabase.database.DBHelper
import com.example.sqlitedatabase.models.Employee
import kotlinx.android.synthetic.main.activity_employee_list.*
import kotlinx.android.synthetic.main.row_adapter_employee.*

class EmployeeListActivity : AppCompatActivity() {
    var mList:ArrayList<Employee> = ArrayList()
    private var adapterEmployee:AdapterEmployee? = null
    lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)
        dbHelper = DBHelper(this)

        init()
    }

    private fun init() {
        mList = dbHelper.getEmployee()
        adapterEmployee = AdapterEmployee(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterEmployee

        button_add.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
            adapterEmployee?.setData(mList)
        }




    }

    override fun onResume() {
        super.onResume()
        mList = dbHelper.getEmployee()
        adapterEmployee?.setData(mList)
    }
}