package com.hendro.androidkotlinbindingbasicui

import android.R
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.google.android.material.snackbar.Snackbar
import com.hendro.androidkotlinbindingbasicui.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onStart() {
        super.onStart()

        //toast
        binding.btToast.setOnClickListener() {
            Toast.makeText(this, R.string.hallo, Toast.LENGTH_SHORT).show()
        }

        binding.btSnack.setOnClickListener() {
            Snackbar.make(binding.root, R.string.close_app, Snackbar.LENGTH_SHORT)
                .setAction(R.string.yes) {
                    finish()
                }
                .show()
        }

        binding.btKeluar.setOnClickListener() {

            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setTitle(R.string.warning)
                .setMessage(R.string.close_app)
                .setPositiveButton(R.string.yes) { dialog, which ->
                    finish()
                }
                .setNegativeButton(R.string.no) { dialog, which ->
                    dialog.cancel()
                }

            val dialog: AlertDialog = builder.create()
            dialog.show()

            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(R.color.alertText)
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(R.color.alertText)

        }

        binding.btNotifikasi.setOnClickListener(){

        }
    }
}