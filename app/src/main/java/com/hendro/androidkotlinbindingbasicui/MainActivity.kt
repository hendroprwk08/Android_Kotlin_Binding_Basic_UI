package com.hendro.androidkotlinbindingbasicui

import android.app.AlertDialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.hendro.androidkotlinbindingbasicui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()

        //toast
        binding.btToast.setOnClickListener() {
            val text = "Hallo"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(this, text, duration)
            toast.show()
        }

        binding.btNotifikasi.setOnClickListener() {

        }

        binding.btKeluar.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.warning)
            builder.setMessage(R.string.close_app)

            builder.setPositiveButton(R.string.yes) { dialog, which ->
                finish()
            }

            builder.setNegativeButton(R.string.no) { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT
                ).show()
            }

            builder.setNeutralButton(R.string.maybe) { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    R.string.maybe, Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()
        }
    }
}