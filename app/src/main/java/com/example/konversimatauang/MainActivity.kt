package com.example.konversimatauang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.konversimatauang.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.konversiButton.setOnClickListener{ hasilKonversi() }
    }
    fun hasilKonversi() {
        val stringInTextField = binding.plainTextInputEditText.text.toString()
        val input = stringInTextField.toDoubleOrNull()
        val selectedId = binding.matauangOptions.checkedRadioButtonId
        val satuanKonversi = when (selectedId) {
            R.id.euro -> 15620.81
            R.id.dollar -> 14366.00
            R.id.yen -> 114.51
            else -> 03831.34
        }
        val indonesianLocale = Locale("in", "ID")
        var hasilAkhir = satuanKonversi * input!!
        val formatKonversi = NumberFormat.getCurrencyInstance(indonesianLocale).format(hasilAkhir)
        binding.hasil.text = getString(R.string.hasil_konversi, formatKonversi)

    }
}