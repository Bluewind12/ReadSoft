package com.example.momonyan.readsoft

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class MelodyActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var startButton: Button
    private val sound = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nameEditText.hint = "名前の入力"
        nameEditText.inputType = 1
        startButton.text = "読み上げ"

        setContentView(nameEditText)
        setContentView(startButton)

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