package com.example.momonyan.readsoft

import android.content.Intent
import android.media.SoundPool
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var readButton: Button
    private lateinit var optionButton: Button

    //音量調整用
    private lateinit var volumeText: TextView
    private lateinit var volumeSeekBar: SeekBar
    private var volumeInt: Int = 100

    //待機時間調整用
    private lateinit var waitText: TextView
    private lateinit var waitSeekBar: SeekBar
    private var waitInt: Int = 0


    //SE用
    private lateinit var soundPool: SoundPool
    private var japaneseSounds: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var specialSounds: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.readEditText)
        readButton = findViewById(R.id.readStartButton)
        optionButton = findViewById(R.id.optionButton)

        volumeText = findViewById(R.id.volumeText)
        volumeSeekBar = findViewById(R.id.volumeSeek)

        waitText = findViewById(R.id.waitText)
        waitSeekBar = findViewById(R.id.waitSeek)

        soundPool = SoundPool.Builder().build()

        loadSounds()

        //SeekBar設定
        volumeSeekBar.max = 200
        volumeSeekBar.progress = 100
        waitSeekBar.max = 1000
        waitSeekBar.progress = 0
        volumeText.text = String.format(Locale.JAPANESE, "%d %%", 100)
        waitText.text = String.format(Locale.JAPANESE, "%d ms", 0)


        //動作
        readButton.setOnClickListener {
            val readStrings = editText.text.split("")
            val utteranceId = this.hashCode().toString() + ""  //utteranceIdの取得

            for (i in 0 until readStrings.size - 1) {
                choiseSound(readStrings[i])
            }
        }
        optionButton.setOnClickListener {
            val intent = Intent(this, ExVoiceActivity::class.java)
            startActivity(intent)
        }

        //SeekBar
        volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //ツマミがドラッグされると呼ばれる
            override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // 68 % のようにフォーマト、
                // この場合、Locale.USが汎用的に推奨される
                volumeText.text = String.format(Locale.JAPANESE, "%d %%", progress)
                volumeInt = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // ツマミがタッチされた時に呼ばれる
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // ツマミがリリースされた時に呼ばれる
            }
        })
        waitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //ツマミがドラッグされると呼ばれる
            override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // 68 % のようにフォーマト、
                // この場合、Locale.USが汎用的に推奨される
                waitText.text = String.format(Locale.JAPANESE, "%d ms", progress)
                waitInt = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // ツマミがタッチされた時に呼ばれる
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // ツマミがリリースされた時に呼ばれる
            }
        })
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

    public fun choiseSound(choiceString: String) {
        when (choiceString) {
            "あ" -> {
                soundPool.play(japaneseSounds[0], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(270)
            }
            "い" -> {
                soundPool.play(japaneseSounds[1], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(270)

            }
            "う" -> {
                soundPool.play(japaneseSounds[2], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(250)

            }
            "え" -> {
                soundPool.play(japaneseSounds[3], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(270)

            }
            "お" -> {
                soundPool.play(japaneseSounds[4], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(200)
            }
            "か" -> {
                soundPool.play(japaneseSounds[5], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(200)
            }
            "き" -> {
                soundPool.play(japaneseSounds[6], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(200)
            }
            "く" -> {
                soundPool.play(japaneseSounds[7], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(200)
            }
            "け" -> {
                soundPool.play(japaneseSounds[8], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(220)
            }
            "こ" -> {
                soundPool.play(japaneseSounds[9], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(830)
            }
            "さ" -> {
                soundPool.play(japaneseSounds[10], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(180)
            }
            "し" -> {
                soundPool.play(japaneseSounds[11], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(200)
            }
            "す" -> {
                soundPool.play(japaneseSounds[12], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(430)
            }
            "せ" -> {
                soundPool.play(japaneseSounds[13], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(500)
            }
            "そ" -> {
                soundPool.play(japaneseSounds[14], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(240)
            }
            "た" -> {
                soundPool.play(japaneseSounds[15], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(400)
            }
            "ち" -> {
                soundPool.play(japaneseSounds[16], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(350)
            }
            "つ" -> {
                soundPool.play(japaneseSounds[17], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(500)
            }
            "て" -> {
                soundPool.play(japaneseSounds[18], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(550)
            }
            "と" -> {
                soundPool.play(japaneseSounds[19], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(500)
            }
            "な" -> {
                soundPool.play(japaneseSounds[20], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(350)
            }
            "に" -> {
                soundPool.play(japaneseSounds[21], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(400)
            }
            "ぬ" -> {
                soundPool.play(japaneseSounds[22], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(220)
            }
            "ね" -> {
                soundPool.play(japaneseSounds[23], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(300)
            }
            "の" -> {
                soundPool.play(japaneseSounds[24], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(330)
            }
            "は" -> {
                soundPool.play(japaneseSounds[25], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(310)
            }
            "ひ" -> {
                soundPool.play(japaneseSounds[26], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(320)
            }
            "ふ" -> {
                soundPool.play(japaneseSounds[27], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(220)
            }
            "へ" -> {
                soundPool.play(japaneseSounds[28], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(260)
            }
            "ほ" -> {
                soundPool.play(japaneseSounds[29], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(160)
            }
            "ま" -> {
                soundPool.play(japaneseSounds[30], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(200)
            }
            "み" -> {
                soundPool.play(japaneseSounds[31], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(300)
            }
            "む" -> {
                soundPool.play(japaneseSounds[32], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(180)
            }
            "め" -> {
                soundPool.play(japaneseSounds[33], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(200)
            }
            "も" -> {
                soundPool.play(japaneseSounds[34], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(170)
            }
            "や" -> {
                soundPool.play(japaneseSounds[35], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(280)
            }
            "ゆ" -> {
                soundPool.play(japaneseSounds[36], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(270)
            }
            "よ" -> {
                soundPool.play(japaneseSounds[37], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(220)
            }
            "ら" -> {
                soundPool.play(japaneseSounds[38], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(290)
            }
            "り" -> {
                soundPool.play(japaneseSounds[39], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(250)
            }
            "る" -> {
                soundPool.play(japaneseSounds[40], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(230)
            }
            "れ" -> {
                soundPool.play(japaneseSounds[41], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(230)
            }
            "ろ" -> {
                soundPool.play(japaneseSounds[42], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(260)
            }
            "わ" -> {
                soundPool.play(japaneseSounds[43], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(290)
            }
            "を" -> {
                soundPool.play(japaneseSounds[44], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(290)
            }
            "ん" -> {
                soundPool.play(japaneseSounds[45], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(170)
            }
            "だ" -> {
                soundPool.play(japaneseSounds[46], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(360)
            }
        //特殊ボイス
        //曲系
            "イ" -> {
                //イントロ
                soundPool.play(specialSounds[11], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(2000)
            }
            "間" -> {
                //間奏
                soundPool.play(specialSounds[12], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(3100)
            }
            "力" -> {
                //悪魔の力身につけた
                soundPool.play(specialSounds[2], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(7200)
            }
            "誰" -> {
                //あれは誰だ
                soundPool.play(specialSounds[3], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(6900)
            }
            "捨" -> {
                //すべてを捨てて戦う男
                soundPool.play(specialSounds[19], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(3700)
            }
        //マン！
            "1" -> {
                //まん！（短）
                soundPool.play(specialSounds[15], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(1500)
            }
            "2" -> {
                //まーん！（中）
                soundPool.play(specialSounds[16], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(770)
            }
            "3" -> {
                //まーーーん！（長）
                soundPool.play(specialSounds[14], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(11000)
            }
            "4" -> {
                //まーん！（下げ）
                soundPool.play(specialSounds[17], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(1800)
            }
        //あー
            "!" -> {
                //あー！
                soundPool.play(specialSounds[0], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(1150)
            }
            "！" -> {
                //あー！（伸ばし）
                soundPool.play(specialSounds[1], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(330)
            }
        //デビル
            "目" -> {
                //デビルアイ
                soundPool.play(specialSounds[4], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(330)
            }
            "矢" -> {
                //デビルアロー
                soundPool.play(specialSounds[5], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(1150)
            }
            "耳" -> {
                //デビルイヤー
                soundPool.play(specialSounds[6], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(950)
            }
            "切" -> {
                //デビルカッター
                soundPool.play(specialSounds[7], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(980)
            }
            "足" -> {
                //デビルキック
                soundPool.play(specialSounds[8], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(970)
            }
            "殴" -> {
                //デビルチョップ
                soundPool.play(specialSounds[9], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(1200)
            }
            "羽" -> {
                //デビルウィング
                soundPool.play(specialSounds[10], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(1000)
            }
        //複合ボイス
            "好" -> {
                //ここ好き
                soundPool.play(specialSounds[13], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(900)
            }
            "～" -> {
                //まあそれはそれとして
                soundPool.play(specialSounds[18], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(2000)
            }
            "謝" -> {
                //すまーん！
                soundPool.play(specialSounds[20], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(1200)
            }
            "T" -> {
                //テン☆
                soundPool.play(specialSounds[21], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(440)
            }
            "詫" -> {
                //詫びるマン
                soundPool.play(specialSounds[22], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(2500)
            }
            "＜" -> {
                //わかるマン
                soundPool.play(specialSounds[23], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(2200)
            }
            "＞" -> {
                //わかるマン（間奏入り）
                soundPool.play(specialSounds[24], volumeInt.toFloat(), volumeInt.toFloat(), 0, 0, 1.0f)
                sleepWait(5400)
            }
        //待機
            "+" -> sleepWait(500)

        }
        sleepWait(waitInt.toLong())
    }

    private fun sleepWait(ms: Long) {
        try {
            Thread.sleep(ms)
        } catch (e: InterruptedException) {
        }
    }
}
