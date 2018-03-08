package com.project.vgalovic.todoListKotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by vgalovic on 28.02.2018..
 */

class DbHelper (context:Context) : SQLiteOpenHelper(context, dbName, factory, version){

    companion object {
        internal const val dbName = "myDB"
        internal  val factory = null
        internal const val  version = 1
    }

    fun addTask(task:String){
        val db : SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put("task", task)

        db.insert("Task", null, values)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Task(id integer primary key auto_increment, task varchar(20))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}