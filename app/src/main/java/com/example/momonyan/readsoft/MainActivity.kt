package com.example.momonyan.readsoft

import android.media.SoundPool
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
    private lateinit var soundPool: SoundPool
    private var japaneseSounds: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var specialSounds: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.readEditText)
        readButton = findViewById(R.id.readStartButton)
        optionButton = findViewById(R.id.optionButton)

        tts = TextToSpeech(applicationContext, SampleInitListener())  //テキストトゥスピーチオブジェクトの生成と、イベントリスナーの登録
        tts.language = Locale.JAPANESE  //読み上げる言語の設定
        soundPool = SoundPool.Builder().build()

        loadSounds()


        readButton.setOnClickListener {
            val readStrings = editText.text.split("")
            val readString = editText.text
            val utteranceId = this.hashCode().toString() + ""  //utteranceIdの取得

//            //ttsの再生
//            for (i in 0 until readStrings.size - 1) {
//                Log.d("ReadString" + i + "：", readStrings[i])
//                if (tts.isSpeaking) {
//                    tts.stop()
//                }
//                tts.speak(readStrings[i], TextToSpeech.QUEUE_ADD, null, utteranceId)
//            }
            for (i in 0 until readStrings.size - 1) {
                choiseSound(readStrings[i])
            }
        }
    }

    internal inner class SampleInitListener : TextToSpeech.OnInitListener {
        override fun onInit(status: Int) {}

    }

    private fun loadSounds() {
        japaneseSounds[0] = soundPool.load(this, R.raw.a, 1)
        japaneseSounds[1] = soundPool.load(this, R.raw.i, 1)
        japaneseSounds[2] = soundPool.load(this, R.raw.u, 1)
        japaneseSounds[3] = soundPool.load(this, R.raw.e, 1)
        japaneseSounds[4] = soundPool.load(this, R.raw.o, 1)
        japaneseSounds[5] = soundPool.load(this, R.raw.ka, 1)
        japaneseSounds[6] = soundPool.load(this, R.raw.ki, 1)
        japaneseSounds[7] = soundPool.load(this, R.raw.ku, 1)
        japaneseSounds[8] = soundPool.load(this, R.raw.ke, 1)
        japaneseSounds[9] = soundPool.load(this, R.raw.ko, 1)
        japaneseSounds[10] = soundPool.load(this, R.raw.sa, 1)
        japaneseSounds[11] = soundPool.load(this, R.raw.si, 1)
        japaneseSounds[12] = soundPool.load(this, R.raw.su, 1)
        japaneseSounds[13] = soundPool.load(this, R.raw.se, 1)
        japaneseSounds[14] = soundPool.load(this, R.raw.so, 1)
        japaneseSounds[15] = soundPool.load(this, R.raw.ta, 1)
        japaneseSounds[16] = soundPool.load(this, R.raw.ti, 1)
        japaneseSounds[17] = soundPool.load(this, R.raw.tu, 1)
        japaneseSounds[18] = soundPool.load(this, R.raw.te, 1)
        japaneseSounds[19] = soundPool.load(this, R.raw.to, 1)
        japaneseSounds[20] = soundPool.load(this, R.raw.na, 1)
        japaneseSounds[21] = soundPool.load(this, R.raw.ni, 1)
        japaneseSounds[22] = soundPool.load(this, R.raw.nu, 1)
        japaneseSounds[23] = soundPool.load(this, R.raw.ne, 1)
        japaneseSounds[24] = soundPool.load(this, R.raw.no, 1)
        japaneseSounds[25] = soundPool.load(this, R.raw.ha, 1)
        japaneseSounds[26] = soundPool.load(this, R.raw.hi, 1)
        japaneseSounds[27] = soundPool.load(this, R.raw.hu, 1)
        japaneseSounds[28] = soundPool.load(this, R.raw.he, 1)
        japaneseSounds[29] = soundPool.load(this, R.raw.ho, 1)
        japaneseSounds[30] = soundPool.load(this, R.raw.ma, 1)
        japaneseSounds[31] = soundPool.load(this, R.raw.mi, 1)
        japaneseSounds[32] = soundPool.load(this, R.raw.mu, 1)
        japaneseSounds[33] = soundPool.load(this, R.raw.me, 1)
        japaneseSounds[34] = soundPool.load(this, R.raw.mo, 1)
        japaneseSounds[35] = soundPool.load(this, R.raw.ya, 1)
        japaneseSounds[36] = soundPool.load(this, R.raw.yu, 1)
        japaneseSounds[37] = soundPool.load(this, R.raw.yo, 1)
        japaneseSounds[38] = soundPool.load(this, R.raw.ra, 1)
        japaneseSounds[39] = soundPool.load(this, R.raw.ri, 1)
        japaneseSounds[40] = soundPool.load(this, R.raw.ru, 1)
        japaneseSounds[41] = soundPool.load(this, R.raw.re, 1)
        japaneseSounds[42] = soundPool.load(this, R.raw.ro, 1)
        japaneseSounds[43] = soundPool.load(this, R.raw.wa, 1)
        japaneseSounds[44] = soundPool.load(this, R.raw.wo, 1)
        japaneseSounds[45] = soundPool.load(this, R.raw.n, 1)
        japaneseSounds[46] = soundPool.load(this, R.raw.da, 1)

        specialSounds[0] = soundPool.load(this, R.raw.a__, 1)
        specialSounds[1] = soundPool.load(this, R.raw.a_nobashi, 1)
        specialSounds[2] = soundPool.load(this, R.raw.akumnotikara, 1)
        specialSounds[3] = soundPool.load(this, R.raw.arehadareda, 1)
        specialSounds[4] = soundPool.load(this, R.raw.debiruai, 1)
        specialSounds[5] = soundPool.load(this, R.raw.debiruaro_, 1)
        specialSounds[6] = soundPool.load(this, R.raw.debiruiya_, 1)
        specialSounds[7] = soundPool.load(this, R.raw.debirukatta, 1)
        specialSounds[8] = soundPool.load(this, R.raw.debirukikku, 1)
        specialSounds[9] = soundPool.load(this, R.raw.debirutyopu, 1)
        specialSounds[10] = soundPool.load(this, R.raw.debiruwingu, 1)
        specialSounds[11] = soundPool.load(this, R.raw.intro, 1)
        specialSounds[12] = soundPool.load(this, R.raw.kansou, 1)
        specialSounds[13] = soundPool.load(this, R.raw.kokosuki, 1)
        specialSounds[14] = soundPool.load(this, R.raw.maaaaaaaaaaaaaan, 1)
        specialSounds[15] = soundPool.load(this, R.raw.man, 1)
        specialSounds[16] = soundPool.load(this, R.raw.maaaaan, 1)
        specialSounds[17] = soundPool.load(this, R.raw.maaaaan_sage, 1)
        specialSounds[18] = soundPool.load(this, R.raw.maasorehasoretosite, 1)
        specialSounds[19] = soundPool.load(this, R.raw.subetewosutetetatakauotoko, 1)
        specialSounds[20] = soundPool.load(this, R.raw.sumaaaaaan, 1)
        specialSounds[21] = soundPool.load(this, R.raw.ten, 1)
        specialSounds[22] = soundPool.load(this, R.raw.wabiruman, 1)
        specialSounds[23] = soundPool.load(this, R.raw.wakaruman, 1)
        specialSounds[24] = soundPool.load(this, R.raw.wakaruman_kansou, 1)

    }

    private fun choiseSound(choiceString: String) {
        when (choiceString) {
            "あ" -> {
                soundPool.play(japaneseSounds[0], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(270)
            }
            "い" -> {
                soundPool.play(japaneseSounds[1], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(270)

            }
            "う" -> {
                soundPool.play(japaneseSounds[2], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(250)

            }
            "え" -> {
                soundPool.play(japaneseSounds[3], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(270)

            }
            "お" -> {
                soundPool.play(japaneseSounds[4], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(200)
            }
            "か" -> {
                soundPool.play(japaneseSounds[5], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(200)
            }
            "き" -> {
                soundPool.play(japaneseSounds[6], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(200)
            }
            "く" -> {
                soundPool.play(japaneseSounds[7], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(200)
            }
            "け" -> {
                soundPool.play(japaneseSounds[8], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(220)
            }
            "こ" -> {
                soundPool.play(japaneseSounds[9], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(830)
            }
            "さ" -> {
                soundPool.play(japaneseSounds[10], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(180)
            }
            "し" -> {
                soundPool.play(japaneseSounds[11], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(200)
            }
            "す" -> {
                soundPool.play(japaneseSounds[12], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(430)
            }
            "せ" -> {
                soundPool.play(japaneseSounds[13], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(500)
            }
            "そ" -> {
                soundPool.play(japaneseSounds[14], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(240)
            }
            "た" -> {
                soundPool.play(japaneseSounds[15], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(400)
            }
            "ち" -> {
                soundPool.play(japaneseSounds[16], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(350)
            }
            "つ" -> {
                soundPool.play(japaneseSounds[17], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(500)
            }
            "て" -> {
                soundPool.play(japaneseSounds[18], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(550)
            }
            "と" -> {
                soundPool.play(japaneseSounds[19], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(500)
            }
            "な" -> {
                soundPool.play(japaneseSounds[20], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(350)
            }
            "に" -> {
                soundPool.play(japaneseSounds[21], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(400)
            }
            "ぬ" -> {
                soundPool.play(japaneseSounds[22], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(220)
            }
            "ね" -> {
                soundPool.play(japaneseSounds[23], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(300)
            }
            "の" -> {
                soundPool.play(japaneseSounds[24], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(330)
            }
            "は" -> {
                soundPool.play(japaneseSounds[25], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(310)
            }
            "ひ" -> {
                soundPool.play(japaneseSounds[26], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(320)
            }
            "ふ" -> {
                soundPool.play(japaneseSounds[27], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(220)
            }
            "へ" -> {
                soundPool.play(japaneseSounds[28], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(260)
            }
            "ほ" -> {
                soundPool.play(japaneseSounds[29], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(160)
            }
            "ま" -> {
                soundPool.play(japaneseSounds[30], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(200)
            }
            "み" -> {
                soundPool.play(japaneseSounds[31], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(300)
            }
            "む" -> {
                soundPool.play(japaneseSounds[32], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(180)
            }
            "め" -> {
                soundPool.play(japaneseSounds[33], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(200)
            }
            "も" -> {
                soundPool.play(japaneseSounds[34], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(170)
            }
            "や" -> {
                soundPool.play(japaneseSounds[35], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(280)
            }
            "ゆ" -> {
                soundPool.play(japaneseSounds[36], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(270)
            }
            "よ" -> {
                soundPool.play(japaneseSounds[37], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(220)
            }
            "ら" -> {
                soundPool.play(japaneseSounds[38], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(290)
            }
            "り" -> {
                soundPool.play(japaneseSounds[39], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(250)
            }
            "る" -> {
                soundPool.play(japaneseSounds[40], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(230)
            }
            "れ" -> {
                soundPool.play(japaneseSounds[41], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(230)
            }
            "ろ" -> {
                soundPool.play(japaneseSounds[42], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(260)
            }
            "わ" -> {
                soundPool.play(japaneseSounds[43], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(290)
            }
            "を" -> {
                soundPool.play(japaneseSounds[44], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(290)
            }
            "ん" -> {
                soundPool.play(japaneseSounds[45], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(170)
            }
            "だ" -> {
                soundPool.play(japaneseSounds[46], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(360)
            }
            "1" -> {
                soundPool.play(specialSounds[0], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(1150)
            }
            "2" -> {
                soundPool.play(specialSounds[1], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(330)
            }
            "3" -> {
                soundPool.play(specialSounds[2], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(7200)
            }
            "4" -> {
                soundPool.play(specialSounds[3], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(6900)
            }
            "5" -> {
                soundPool.play(specialSounds[4], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(330)
            }
            "6" -> {
                soundPool.play(specialSounds[5], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(1150)
            }
            "7" -> {
                soundPool.play(specialSounds[6], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(950)
            }
            "8" -> {
                soundPool.play(specialSounds[7], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(980)
            }
            "9" -> {
                soundPool.play(specialSounds[8], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(970)
            }
            "A" -> {
                soundPool.play(specialSounds[9], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(1200)
            }
            "B" -> {
                soundPool.play(specialSounds[10], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(1000)
            }
            "C" -> {
                soundPool.play(specialSounds[11], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(2000)
            }
            "D" -> {
                soundPool.play(specialSounds[12], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(3100)
            }
            "E" -> {
                soundPool.play(specialSounds[13], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(900)
            }
            "F" -> {
                soundPool.play(specialSounds[14], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(11000)
            }
            "G" -> {
                soundPool.play(specialSounds[15], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(1500)
            }
            "H" -> {
                soundPool.play(specialSounds[16], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(770)
            }
            "I" -> {
                soundPool.play(specialSounds[17], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(1800)
            }
            "J" -> {
                soundPool.play(specialSounds[18], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(2000)
            }
            "K" -> {
                soundPool.play(specialSounds[19], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(3700)
            }
            "L" -> {
                soundPool.play(specialSounds[20], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(1200)
            }
            "M" -> {
                soundPool.play(specialSounds[21], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(440)
            }
            "N" -> {
                soundPool.play(specialSounds[22], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(2500)
            }
            "O" -> {
                soundPool.play(specialSounds[23], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(2200)
            }
            "P" -> {
                soundPool.play(specialSounds[24], 1.0f, 1.0f, 0, 0, 1.0f)
                sleepWait(5400)
            }
            "+" -> sleepWait(500)
        }
    }

    private fun sleepWait(ms: Long) {
        try {
            Thread.sleep(ms)
        } catch (e: InterruptedException) {
        }
    }
}
