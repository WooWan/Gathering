package com.example.gatheringfront

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gatheringfront.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DataBindingUtil.
        setContentView(binding.root)

    }
}