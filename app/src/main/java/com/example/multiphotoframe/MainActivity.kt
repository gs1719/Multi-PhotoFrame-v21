package com.example.multiphotoframe

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.multiphotoframe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentImage = 0
    private val petNameArray = arrayOf("Labrador Puppy","German Shepherd","Chow Chow","Husky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        remove action bar or app name
        supportActionBar?.hide()


        binding.btnPrevious.setOnClickListener {
            btnAnimate(binding.btnPrevious)
            when ("pic$currentImage") {
                "pic0" -> {
                    binding.pic3.alpha = 1f
                    binding.pic0.alpha = 0f
                    setValues(3)

                }
                "pic1" -> {
                    binding.pic0.alpha = 1f
                    binding.pic1.alpha = 0f
                    setValues(0)
                }
                "pic2" -> {
                    binding.pic1.alpha = 1f
                    binding.pic2.alpha = 0f
                    setValues(1)
                }
                "pic3" -> {
                    binding.pic3.alpha = 0f
                    binding.pic2.alpha = 1f
                    setValues(2)
                }
            }
        }
        binding.btnForward.setOnClickListener {
            btnAnimate(binding.btnForward)
            when ("pic$currentImage") {
                "pic0" -> {
                    binding.pic0.alpha = 0f
                    binding.pic1.alpha = 1f
                    setValues(1)
                }
                "pic1" -> {
                    binding.pic1.alpha = 0f
                    binding.pic2.alpha = 1f
                    setValues(2)
                }
                "pic2" -> {
                    binding.pic2.alpha = 0f
                    binding.pic3.alpha = 1f
                    setValues(3)
                }
                "pic3" -> {
                    binding.pic3.alpha = 0f
                    binding.pic0.alpha = 1f
                    setValues(0)
                }
            }
        }
    }
    private fun setValues(n: Int) {
        currentImage = n
        binding.tvName.text = petNameArray[n]
    }

    private fun btnAnimate(button: ImageButton) {
        //Set button alpha to zero
        button.alpha = 0f

        //Animate the alpha value to 1f and set duration as 1.5 secs.
        button.animate().alpha(1f).duration = 400
    }

}