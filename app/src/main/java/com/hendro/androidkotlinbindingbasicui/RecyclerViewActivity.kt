package com.hendro.androidkotlinbindingbasicui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        //masukkan data
        temanList.add(Teman("Andri Dewanto", "Klub Sepak Takraw", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Sutejo", "Ka Prodi", "https://img.freepik.com/free-photo/handsome-young-man-with-new-stylish-haircut_176420-19636.jpg"))
        temanList.add(Teman("Anggita", "Dosen Kimia", "https://img.freepik.com/premium-photo/portrait-confident-beautiful-brunette-woman-turning-face-camera-with-dreamy-look-white_1258-19144.jpg"))
        temanList.add(Teman("Andri Dewanto", "Klub Sepak Takraw", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg"))
        temanList.add(Teman("Dona", "Dossen Matematika", "https://img.freepik.com/free-photo/portrait-young-woman-with-natural-make-up_23-2149084942.jpg"))
        temanList.add(Teman("Yunita", "Klub Bola", "https://img.freepik.com/free-photo/beautiful-woman-with-black-jacket_144627-21704.jpg"))
        temanList.add(Teman("Desta", "Ipar", "https://img.freepik.com/free-photo/elegant-senior-man-posing-suit_23-2149488009.jpg"))
        temanList.add(Teman("Baim", "Ipar", "https://img.freepik.com/free-psd/portrait-senior-man-smiling_23-2150115978.jpg"))
        temanList.add(Teman("El", "Mertua", "https://img.freepik.com/free-photo/emotions-people-concept-headshot-serious-looking-handsome-man-with-beard-looking-confident-determined_1258-26730.jpg"))
        temanList.add(Teman("Hasan", "Tek Industri", "https://img.freepik.com/free-photo/man-suit-with-raised-eyebrow_1194-1005.jpg"))

        //set recyclerview adapter
        recyclerViewAdapter = RecycleViewAdapter(temanList)

        // refresh adapter
        recyclerViewAdapter.notifyDataSetChanged()

        val layoutManager = GridLayoutManager(this, 1) //jumlah kolom 1
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = recyclerViewAdapter

        binding.recyclerView.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }
}