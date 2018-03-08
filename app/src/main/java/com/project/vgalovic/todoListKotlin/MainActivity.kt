package com.project.vgalovic.todoListKotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val title = "Task"
    private val message = "Add task:"
    private val ok = "OK"
    private val cancel = "CANCEL"

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val helper = DbHelper(this@MainActivity)

        fab.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this).create()
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)

            with(alertDialog){
                setTitle(title)
                setMessage(message)

                val editTextTask = dialogView.findViewById<EditText>(R.id.editText)
                setView(dialogView)
                setCancelable(false)

                setButton(AlertDialog.BUTTON_POSITIVE, ok, {
                    dialog, _ -> dialog.dismiss()

                    val task : String = editTextTask.toString()
                    helper.addTask(task)

                    Toast.makeText(this@MainActivity,"Iserted sucessfully", Toast.LENGTH_SHORT).show()
                })

                setButton(AlertDialog.BUTTON_NEGATIVE, cancel, {
                    dialog, _ -> dialog.dismiss()
                })
            }

            alertDialog!!.show()
        }
    }
}
