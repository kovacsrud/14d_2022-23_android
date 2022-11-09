package com.raz.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.raz.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var testadatok=TestAdatok(0.0f,0.0f,0.0f,0.0f)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.testadat=testadatok

        binding.buttonSzamolas.setOnClickListener {
            var magassag=binding.magassagErtek.text.toString().toFloat()
            var testsuly=binding.testsulyErtek.text.toString().toFloat()

            testadatok.idealisSuly=(magassag-100)*0.9f
            magassag=magassag/100
            testadatok.bmiIndex=testsuly/(magassag*magassag)

            binding.invalidateAll()
        }

        //setContentView(R.layout.activity_main)
    }
}