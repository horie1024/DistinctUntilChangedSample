package com.horie1024.distinctuntilchangedsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.horie1024.distinctuntilchangedsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.button.setOnClickListener {
            viewModel.setValue(binding.editText.text.toString().toInt())
        }
    }
}
