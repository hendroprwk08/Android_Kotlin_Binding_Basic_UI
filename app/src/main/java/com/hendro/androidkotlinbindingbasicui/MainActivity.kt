package com.hendro.androidkotlinbindingbasicui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Notification
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar
import com.hendro.androidkotlinbindingbasicui.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var CHANNEL_ID = "MyChannel"
    lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)
    }

    @SuppressLint("ResourceAsColor", "MissingPermission")
    override fun onStart() {
        super.onStart()

        //toast
        binding.btToast.setOnClickListener() {
            Toast.makeText(this, resources.getString(R.string.hallo), Toast.LENGTH_SHORT).show()
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

        binding.btNotifikasi.setOnClickListener() {
            //hanya notifikasi
            val mChannel = NotificationChannelCompat.Builder(CHANNEL_ID, NotificationManagerCompat.IMPORTANCE_DEFAULT).apply {
                setName(getString(R.string.hallo)) // Must set! Don't remove
                setDescription(getString(R.string.description))
                setLightsEnabled(true)
                setLightColor(Color.RED)
                setVibrationEnabled(true)
                setVibrationPattern(longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400))
            }.build()

            NotificationManagerCompat.from(applicationContext).createNotificationChannel(mChannel)

            val notification: Notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                .setSmallIcon(R.drawable.baseline_lightbulb_24)
                .setContentTitle(getString(R.string.hallo))
                .setContentText(getString(R.string.description))
                .build()
            NotificationManagerCompat.from(applicationContext).notify(1, notification)

            //dengan pending Intent
            /*
            val resultIntent = Intent(this, NotifActivity::class.java) //intent

            val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(resultIntent)
                getPendingIntent(
                    0,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
            }

            val mChannel = NotificationChannelCompat.Builder(
                CHANNEL_ID,
                NotificationManagerCompat.IMPORTANCE_DEFAULT
            ).apply {
                setName(getString(R.string.hallo)) // Must set! Don't remove
                setDescription(getString(R.string.description))
                setLightsEnabled(true)
                setLightColor(Color.RED)
                setVibrationEnabled(true)
                setVibrationPattern(longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400))
            }.build()

            NotificationManagerCompat.from(applicationContext).createNotificationChannel(mChannel)

            val notification: Notification =
                NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                    .setSmallIcon(R.drawable.baseline_lightbulb_24)
                    .setContentTitle(getString(R.string.hallo))
                    .setContentText(getString(R.string.description))
                    .setContentIntent(resultPendingIntent)
                    .build()
            NotificationManagerCompat.from(applicationContext).notify(1, notification)
            */
        }

        binding.btDetil.setOnClickListener() {
            //ambi nilai dari radio group
            val selectedOption: Int = binding.rgDomisili!!.checkedRadioButtonId
            radioButton = findViewById(selectedOption)
            var domisili:String = radioButton.text.toString()

            val bundle = Bundle()
            bundle.putString("b_nama", binding.etNama.text.toString())
            bundle.putString("b_alamat", binding.etAlamat.text.toString())
            bundle.putString("b_prodi", binding.spProdi.selectedItem.toString())
            bundle.putString("b_domisili", domisili)
            bundle.putBoolean("b_teknologi", binding.cbTeknologi.isChecked)
            bundle.putBoolean("b_kuliner", binding.cbKuliner.isChecked)

            val intent = Intent(this, DetilActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_item, menu)

        //khusus proses search
        val item = menu.findItem(R.id.menu_cari)
        val searchView = item.actionView as SearchView?
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean { //ketika tekan enter
                Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(s: String): Boolean { //ketika text berubah
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_fragment -> {
                val intent = Intent(this, FragmentActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.menu_recycler_iew -> {
                Toast.makeText(applicationContext, R.string.recycler_view, Toast.LENGTH_SHORT)
                    .show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}