package com.seonghyeon.android.secretdiary

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DiaryActivity: AppCompatActivity() {

    // Handler: 안드로이드에서 제공하는 쓰레드간의 통신을 엮어주는 기능.
    private val handler = Handler(Looper.getMainLooper())

    // onCreate 시점은 뷰가 완전히 그려졌을 시점이다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val diaryEditText = findViewById<EditText>(R.id.diaryEditText)
        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)

        diaryEditText.setText(detailPreferences.getString("detail", ""))

        // 쓰다가 잠깐 멈칫했을 때 저장. 쓰레드
        val runnable = Runnable {
            getSharedPreferences("diary", Context.MODE_PRIVATE).edit {
                putString("detail", diaryEditText.text.toString())
            }

            Log.d("DiaryActivity", "SAVE!!! ${diaryEditText.text.toString()}")
        }

        // 내용이 수정될 때마다 저장.
        diaryEditText.addTextChangedListener {
            Log.d("DiaryActivity", "TextChanged :: $it")
            handler.removeCallbacks(runnable)   // runnable 제거
            handler.postDelayed(runnable, 500)  // 0.5초마다
        }
    }
}