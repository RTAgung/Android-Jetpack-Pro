package com.example.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mLiveDataTimerViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLiveDataTimerViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long?> { aLong ->
            val newText = this@MainActivity.resources.getString(R.string.seconds, aLong)
            timer_textview.text = newText
        }
        mLiveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}