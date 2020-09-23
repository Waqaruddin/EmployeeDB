package com.example.sqlitedatabase.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitedatabase.R
import com.example.sqlitedatabase.activities.DeleteActivity
import com.example.sqlitedatabase.activities.UpdateActivity
import com.example.sqlitedatabase.database.DBHelper
import com.example.sqlitedatabase.models.Employee
import kotlinx.android.synthetic.main.row_adapter_employee.view.*

class AdapterEmployee(var mContext: Context, var mList:ArrayList<Employee>): RecyclerView.Adapter<AdapterEmployee.MyViewHolder>(){


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(employee:Employee, position: Int){
            itemView.text_view_name.text = employee.name
            itemView.text_view_id.text = employee.id.toString()

            itemView.button_edit.setOnClickListener {
                mContext.startActivity(Intent(mContext, UpdateActivity::class.java).putExtra("key", employee.id ))
            }

            itemView.button_delete.setOnClickListener {
                var dbHelper = DBHelper(mContext)
                dbHelper.deleteEmployee(employee.id)
                mList.removeAt(position)
                notifyItemRemoved(position)
            }

        }
    }

    fun setData(l:ArrayList<Employee>){
        mList = l
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_employee, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var employee = mList[position]

        holder.bind(employee, position)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}