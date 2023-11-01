package com.hendro.androidkotlinbindingbasicui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.hendro.androidkotlinbindingbasicui.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private val temanList = ArrayList<Teman>()
    private lateinit var recyclerViewAdapter: RecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //back button
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    fun loadData(){
        //set recyclerview adapter
        recyclerViewAdapter = RecycleViewAdapter(temanList)

        val layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = recyclerViewAdapter

        //masukkan data
        temanList.add(Teman("Andri Dewanto", "Klub Sepak Takraw", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Sutejo", "Tek Industri", "https://img.freepik.com/free-photo/handsome-young-man-with-new-stylish-haircut_176420-19636.jpg"))
        temanList.add(Teman("Andri Dewanto", "Pacar 1", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Klub Sepak Takraw", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Ipar", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Mantan 1", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Klub Bola", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Ipar", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Ipar", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Mertua", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Tek Industri", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Pacar 2", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Tetangga", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Mantan 2", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Andri Dewanto", "Temen", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))

        // refresh adapter
        recyclerViewAdapter.notifyDataSetChanged()
    }
}