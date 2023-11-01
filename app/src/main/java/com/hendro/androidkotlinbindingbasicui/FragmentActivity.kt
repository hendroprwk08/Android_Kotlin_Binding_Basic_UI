package com.hendro.androidkotlinbindingbasicui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.hendro.androidkotlinbindingbasicui.databinding.ActivityFragmentBinding


class FragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentBinding

    val fragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // default fragment
        val fragment = SatuFragment()
        setFragment(fragment, 0)
    }

    override fun onStart() {
        super.onStart()

        binding.btSatu.setOnClickListener() {
            val fragment = SatuFragment()
            setFragment(fragment, 1)
        }

        binding.btDua.setOnClickListener() {
            val fragment = DuaFragment()
            setFragment(fragment, 1)
        }
    }

    private fun setFragment(fragment: Fragment, status: Int) {
        val fragmentTransaction = fragmentManager.beginTransaction()

        if(status.equals(0)){ // add
            fragmentTransaction.add(R.id.frame_layout, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(null)
                .commit()
        }else{ // replace
            fragmentTransaction.replace(R.id.frame_layout, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(null)
                .commit()
        }

    }
}