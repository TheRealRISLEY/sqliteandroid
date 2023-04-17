package com.example.sqlite_android_risley

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var ename:EditText
    lateinit var eemail:EditText
    lateinit var eid:EditText
    lateinit var esave:Button
    lateinit var eview:Button
    lateinit var edelete:Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ename = findViewById(R.id.edtname)
        eemail = findViewById(R.id.edtemail)
        eid = findViewById(R.id.edtid)
        esave = findViewById(R.id.btnsave)
        eview = findViewById(R.id.btnview)
        edelete = findViewById(R.id.btndelete)


        //Creating a Database


        db = openOrCreateDatabase("RisleyDB", Context.MODE_PRIVATE, null
        )

        //Creating a Table


        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")



        esave.setOnClickListener {

            var jina_edt = ename.toString().trim()
            var arafa_edt = eemail.toString().trim()
            var kitambulisho_edt = eemail.toString().trim()


            //Validate your edit texts

            if (jina_edt.isEmpty() || arafa_edt.isEmpty() || kitambulisho_edt.isEmpty())
            {
            Toast.makeText(this, "Cannot Submit an Empty Field",Toast.LENGTH_SHORT).show()

        }else{
        //insert data

            db.execSQL("INSERT INTO users VALUES('\"+jina_edt+\"', '\"+arafa_edt+\"', '\"+kitambulisho_edt+\"')")
            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
        }

            }


    }
}