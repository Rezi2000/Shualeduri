package com.example.rezichelidzemidterm

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.rezichelidzemidterm.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val now = LocalDate.now()
        val currentYear = now.year.toString()

        val currentMonth = when (now.month.toString()) {
            "JANUARY" -> "01"
            "FEBRUARY" -> "02"
            "MARCH" -> "03"
            "APRIL" -> "04"
            "MAY" -> "05"
            "JUNE" -> "06"
            "JULY" -> "07"
            "AUGUST" -> "08"
            "SEPTEMBER" -> "09"
            "OCTOBER" -> "10"
            "NOVEMBER" -> "11"
            "DECEMBER" -> "12"
            else -> ""
        }

        binding.btnPay.setOnClickListener {
            val isInputValid =
                binding.etCard1.text.length == 4 &&
                        binding.etCard2.text.length == 4 &&
                        binding.etCard3.text.length == 4 &&
                        binding.etCard4.text.length == 4 &&
                        binding.etDateMonth.text.length == 2 &&
                        binding.etDateYear.text.length == 2 &&
                        binding.etCvv.text.length == 3

            if (!isInputValid)
                Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show()
            else {

                val isDateValid = binding.etDateYear.text.toString().toInt() < currentYear.toInt()
                        || (binding.etDateYear.text.toString().toInt() == currentYear.toInt() &&
                        binding.etDateMonth.toString().toInt() >= currentMonth.toInt())


                if (!isDateValid)
                    Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "მიმდინარეობს გადახდა", Toast.LENGTH_SHORT).show()
            }

        }
    }
}