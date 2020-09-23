package com.example.sqlitedatabase.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlitedatabase.models.Employee

class DBHelper(var context:Context):SQLiteOpenHelper(context, DATA_NAME, null , DATABASE_VERSION){

    companion object{
        const val DATA_NAME = "empDB"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "employee"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"

        const val createTable = "create table $TABLE_NAME ($COLUMN_ID INTEGER , $COLUMN_NAME CHAR(50), $COLUMN_EMAIL CHAR(250))"
        const val dropTable = "drop table $TABLE_NAME"


    }
    var database = writableDatabase
    override fun onCreate(database: SQLiteDatabase) {
        database.execSQL(createTable)
    }

    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        database.execSQL(dropTable)
        onCreate(database)
    }

    fun addEmployee(employee: Employee){

        var contentValues = ContentValues()
        contentValues.put(COLUMN_ID, employee.id)
        contentValues.put(COLUMN_NAME, employee.name)
        contentValues.put(COLUMN_EMAIL, employee.email)
        database.insert(TABLE_NAME, null ,contentValues)

    }

    fun updateEmployee(employee:Employee){
        val whereClause = "$COLUMN_ID = ?"
        val whereArg = arrayOf(employee.id.toString())
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, employee.name)
        contentValues.put(COLUMN_EMAIL, employee.email)
        database.update(TABLE_NAME, contentValues, whereClause, whereArg)

    }


    fun deleteEmployee(id:Int){
        var whereClause = "$COLUMN_ID = ?"
        var whereArgs = arrayOf(id.toString())
        database.delete(TABLE_NAME, whereClause, whereArgs)
    }

    fun getEmployee(): ArrayList<Employee>{
        var employeeList:ArrayList<Employee> = ArrayList()
        var database = writableDatabase
        var columns = arrayOf(
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_EMAIL
        )

        var cursor = database.query(TABLE_NAME, columns, null , null , null , null , null)
        if(cursor != null && cursor.moveToFirst()){
            do{
                var id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                var name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                var email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL))
                var employee = Employee(id, name , email)

                employeeList.add(employee)
            }while(cursor.moveToNext())
        }
        cursor.close()
        return employeeList

    }

}