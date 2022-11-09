package com.raz.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raz.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PracticeViewModel
    private lateinit var viewModelFactory: PracticeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory=PracticeViewModelFactory(26)
        viewModel=ViewModelProvider(this,viewModelFactory).get(PracticeViewModel::class.java)

        binding.viewmodel=viewModel

        binding.setLifecycleOwner(this)

        //setContentView(R.layout.activity_main)

    }

}