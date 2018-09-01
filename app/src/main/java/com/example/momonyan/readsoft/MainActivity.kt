package com.example.momonyan.readsoft

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var readButton: Button
    private lateinit var optionButton: Button
    private lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.readEditText)
        readButton = findViewById(R.id.readStartButton)
        optionButton = findViewById(R.id.optionButton)

        tts = TextToSpeech(applicationContext, SampleInitListener())  //テキストトゥスピーチオブジェクトの生成と、イベントリスナーの登録
        tts.language = Locale.JAPANESE  //読み上げる言語の設定

        readButton.setOnClickListener {
            val readStrings = editText.text.split("")
            val readString = editText.text
            for (i in 0 until readStrings.size - 1) {
                Log.d("ReadString" + i + "：", readStrings[i])
            }
            if (tts.isSpeaking) {
                tts.stop()
            }
            val utteranceId = this.hashCode().toString() + ""  //utteranceIdの取得
            tts.speak(readString, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        }
    }

    internal inner class SampleInitListener : TextToSpeech.OnInitListener {
        override fun onInit(status: Int) {}

    }
}
