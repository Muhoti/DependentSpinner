package com.example.dependentspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.dependentspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayList_parent = arrayListOf("Animals", "Birds", "Flowers")
        val arrayAdapter_parent = ArrayAdapter(applicationContext, R.layout.textview_blue, arrayList_parent)
        binding.spinnerBlue.adapter=arrayAdapter_parent

        val arrayList_animals = arrayListOf("Tiger", "Elephant", "Lion", "Monkey", "Cow")
        val arrayList_birds = arrayListOf("Sparrow", "Peacock", "Eagle")
        val arrayList_flowers = arrayListOf("Lotus", "Rose")
        val arrayAdapter_child = ArrayAdapter(applicationContext, R.layout.textview_red, arrayList_animals)
        binding.spinnerRed.adapter = arrayAdapter_child

        binding.spinnerBlue.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position===0){
                    val arrayAdapter_child = ArrayAdapter(applicationContext, R.layout.textview_red, arrayList_animals)
                    binding.spinnerRed.adapter = arrayAdapter_child
                }

                if(position===1){
                    val arrayAdapter_child = ArrayAdapter(applicationContext, R.layout.textview_red, arrayList_birds)
                    binding.spinnerRed.adapter = arrayAdapter_child
                }

                if(position===2){
                    val arrayAdapter_child = ArrayAdapter(applicationContext, R.layout.textview_red, arrayList_flowers)
                    binding.spinnerRed.adapter = arrayAdapter_child
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }

}