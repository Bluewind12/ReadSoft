package com.example.momonyan.readsoft

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var readButton: Button
    private lateinit var optionButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.readEditText)
        readButton = findViewById(R.id.readStartButton)
        optionButton = findViewById(R.id.optionButton)

        readButton.setOnClickListener {
            val readStrings = editText.text.split("")
            for (i in 0 until readStrings.size - 1) {
                Log.d("ReadString" + i + "：", readStrings[i])
            }
        }
    }
}
