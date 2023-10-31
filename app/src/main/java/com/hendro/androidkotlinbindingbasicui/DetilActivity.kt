package com.hendro.androidkotlinbindingbasicui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hendro.androidkotlinbindingbasicui.databinding.ActivityDetilBinding

class DetilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    }

    override fun onStart() {
        super.onStart()

        if(intent.extras != null)
        {
            val bundle = intent.extras
            binding.tvNama.setText(bundle?.getString("b_nama"))
            binding.tvAlamat.setText(bundle?.getString("b_alamat"))
            binding.tvProdi.setText(bundle?.getString("b_prodi"))

            if (bundle?.getString("b_domisili") == "Dalam Kota") {
                binding.rbDK.isChecked = true
            } else {
                binding.rbLK.isChecked = true
            }

            binding.cbTeknologi.isChecked = bundle!!.getBoolean("b_teknologi")
            binding.cbKuliner.isChecked = bundle!!.getBoolean("b_kuliner")
        }else{
            Toast.makeText(this, "Tak ada data", Toast.LENGTH_SHORT).show()
        }
    }

}