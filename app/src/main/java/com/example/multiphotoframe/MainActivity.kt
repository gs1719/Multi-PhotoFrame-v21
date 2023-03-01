package com.example.multiphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiphotoframe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var currentImage = 0
    val petNameArray = arrayOf("Labrador Puppy","German Shepherd","Chow Chow","Husky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        remove action bar or app name
        supportActionBar?.hide()


        binding.btnPrevious.setOnClickListener {
            when ("pic$currentImage") {
                "pic0" -> {
                    binding.pic3.alpha = 1f
                    binding.pic0.alpha = 0f
                    binding.pic1.alpha = 0f
                    binding.pic2.alpha = 0f
                    setValues(3)

                }
                "pic1" -> {
                    binding.pic3.alpha = 0f
                    binding.pic0.alpha = 1f
                    binding.pic1.alpha = 0f
                    binding.pic2.alpha = 0f
                    setValues(0)
                }
                "pic2" -> {
                    binding.pic3.alpha = 0f
                    binding.pic0.alpha = 0f
                    binding.pic1.alpha = 1f
                    binding.pic2.alpha = 0f
                    setValues(1)
                }
                "pic3" -> {
                    binding.pic3.alpha = 0f
                    binding.pic0.alpha = 0f
                    binding.pic1.alpha = 0f
                    binding.pic2.alpha = 1f
                    setValues(2)
                }
            }
        }
        binding.btnForward.setOnClickListener {
            when ("pic$currentImage") {
                "pic0" -> {
                    binding.pic3.alpha = 0f
                    binding.pic0.alpha = 0f
                    binding.pic1.alpha = 1f
                    binding.pic2.alpha = 0f
                    setValues(1)
                }
                "pic1" -> {
                    binding.pic3.alpha = 0f
                    binding.pic0.alpha = 0f
                    binding.pic1.alpha = 0f
                    binding.pic2.alpha = 1f
                    setValues(2)
                }
                "pic2" -> {
                    binding.pic3.alpha = 1f
                    binding.pic0.alpha = 0f
                    binding.pic1.alpha = 0f
                    binding.pic2.alpha = 0f
                    setValues(3)
                }
                "pic3" -> {
                    binding.pic3.alpha = 0f
                    binding.pic0.alpha = 1f
                    binding.pic1.alpha = 0f
                    binding.pic2.alpha = 0f
                    setValues(0)
                }
            }
        }
    }
    private fun setValues(n: Int) {
        currentImage = n
        binding.tvName.text = petNameArray[n]
    }
}