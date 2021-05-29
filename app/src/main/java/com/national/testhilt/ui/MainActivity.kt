package com.national.testhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.national.testhilt.databinding.ActivityMainBinding
import com.national.testhilt.ui.base.BaseActivity
import com.national.testhilt.utils.BASE

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }



}