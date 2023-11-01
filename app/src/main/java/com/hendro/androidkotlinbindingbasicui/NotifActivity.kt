package com.hendro.androidkotlinbindingbasicui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NotifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(RecycleViewAdapter.layout.activity_notif)
    }
}