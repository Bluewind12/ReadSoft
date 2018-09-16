package com.example.momonyan.readsoft

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class melodyActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var startButton: Button
    private val sound = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startButton.setOnClickListener {
            sound.choiseSound("イ")
            sound.choiseSound("誰")
            nameVoice()
            sound.choiseSound("2")
            nameVoice()
            sound.choiseSound("3")
        }

    }

    fun nameVoice() {
        val nameStrings = nameEditText.text.split("")
        for (i in nameStrings) {
            sound.choiseSound(i)
        }
    }
}