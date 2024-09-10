package com.tuncay.btkakademiprojesi1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuncay.btkakademiprojesi1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var result: Double = 0.0
    var firstNum: Double = 0.0
    var secondNum: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    fun plus (view: View){
        if (getNumbers()){
            result = firstNum + secondNum
            val result2 = result.toInt()
            binding.textView.text = "Result: ${result2}"
        }

    }

    fun times (view: View){
        if (getNumbers()){
            result = firstNum * secondNum
            val result2 = result.toInt()
            binding.textView.text = "Result: ${result2}"
        }

    }

    fun divide (view: View){
        if (getNumbers()){
            if (secondNum.toInt() != 0){
                result = firstNum / secondNum
                binding.textView.text = String.format("Result: %.2f", result)
                println("done")
            }
            else{
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Error")
                alert.setMessage("Are you trying to divide ${firstNum.toInt()} to 0?" +
                        "\nYou have to be lost your mind!")
                alert.show()
                println("error")
            }
        }
    }

    fun minus (view: View){
        if (getNumbers()){
            result = firstNum - secondNum
            val result2 = result.toInt()
            binding.textView.text = "Result: ${result2}"
        }

    }

    fun getNumbers(): Boolean {
        if (binding.editTextNumber.text.isEmpty() || binding.editTextNumber2.text.isEmpty()){
            Toast.makeText(this@MainActivity,"Enter a number!",Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            firstNum = binding.editTextNumber.text.toString().toDouble()
            secondNum = binding.editTextNumber2.text.toString().toDouble()
            return true
        }
    }
}