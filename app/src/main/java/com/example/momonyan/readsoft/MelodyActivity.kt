package com.example.momonyan.readsoft

import android.media.SoundPool
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.easy_read_mode_layout.*

class MelodyActivity : AppCompatActivity() {
    private var nameStrings = "".split("")
    private val sound = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.easy_read_mode_layout)

        nameEditText.hint = "名前の入力"
        easyReadButton.text = "読み上げ"

        sound.loadSounds(this)

        easyReadButton.setOnClickListener {
            Thread {
                nameStrings = nameEditText.text.split("")
                sound.choiseSound("誰")
                nameVoice()
                sound.choiseSound("1")
                nameVoice()
                sound.choiseSound("2")
                sound.choiseSound("＞")
            }.start()
        }
    }

    private fun nameVoice() {
        for (i in nameStrings) {
            sound.choiseSound(i)
        }
    }
}