package com.bilgehankalay.unitconverterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.widget.addTextChangedListener
import com.bilgehankalay.unitconverterapp.databinding.ActivityMetersBinding
import android.widget.AdapterView
import java.math.BigDecimal
import java.math.RoundingMode


class MetersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMetersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMetersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ArrayAdapter.createFromResource(this,R.array.length_array,android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.birinciTurSpiner.adapter = adapter
            binding.ikinciTurSpinner.adapter = adapter
        }
        binding.birinciTurSpiner.setSelection(0)
        binding.birinciDegerPlainText.setText("1")
        binding.ikinciTurSpinner.setSelection(1)

        binding.birinciDegerPlainText.addTextChangedListener {
            calculateLength()
        }

        binding.birinciTurSpiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                calculateLength()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.birinciTurSpiner.setSelection(0)
            }
        }
        binding.ikinciTurSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                calculateLength()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.ikinciTurSpinner.setSelection(0)
            }

        }
    }
    fun calculateLength(){
        val value = binding.birinciDegerPlainText.text.toString().toDoubleOrNull()
        if (value == null){
            binding.ikinciDegerPlainText.setText(R.string.error_value)
        }
        else{
            var result = 0.0
            val birinciSpinnerItem = binding.birinciTurSpiner.selectedItem.toString()
            val ikinciSpinnerItem = binding.ikinciTurSpinner.selectedItem.toString()
            if (birinciSpinnerItem == "kilometers"){
                if (ikinciSpinnerItem == "kilometers"){
                    result = value
                }
                else if (ikinciSpinnerItem == "meters"){
                    result = value * 1000
                }
                else if (ikinciSpinnerItem == "centimeters"){
                    result = value * 1000 * 100
                }
                else if (ikinciSpinnerItem == "millimeters"){
                    result = value * 1000 * 100 * 10
                }
                else if (ikinciSpinnerItem == "miles"){
                    result = value * 0.62137
                }
            }
            else if (birinciSpinnerItem == "meters"){
                if (ikinciSpinnerItem == "kilometers"){
                    result = value / 1000
                }
                else if (ikinciSpinnerItem == "meters"){
                    result = value
                }
                else if (ikinciSpinnerItem == "centimeters"){
                    result = value * 100
                }
                else if (ikinciSpinnerItem == "millimeters"){
                    result = value * 100 * 10
                }
                else if (ikinciSpinnerItem == "miles"){
                    result = value / 1000 * 0.62137
                }
            }
            else if (birinciSpinnerItem == "centimeters"){
                if (ikinciSpinnerItem == "kilometers"){
                    result = value / 1000 / 100
                }
                else if (ikinciSpinnerItem == "meters"){
                    result = value / 100
                }
                else if (ikinciSpinnerItem == "centimeters"){
                    result = value
                }
                else if (ikinciSpinnerItem == "millimeters"){
                    result = value * 10
                }
                else if (ikinciSpinnerItem == "miles"){
                    result = value / 1000 / 100 * 0.62137
                }
            }
            else if (birinciSpinnerItem == "millimeters"){
                if (ikinciSpinnerItem == "kilometers"){
                    result = value / 1000 / 100 /10
                }
                else if (ikinciSpinnerItem == "meters"){
                    result = value / 100 / 10
                }
                else if (ikinciSpinnerItem == "centimeters"){
                    result = value / 10
                }
                else if (ikinciSpinnerItem == "millimeters"){
                    result = value
                }
                else if (ikinciSpinnerItem == "miles"){
                    result = value / 1000 /100 /10  * 0.62137
                }
            }
            else if (birinciSpinnerItem == "miles"){
                if (ikinciSpinnerItem == "kilometers"){
                    result = value / 0.62137
                }
                else if (ikinciSpinnerItem == "meters"){
                    result = value / 0.62137 / 1000
                }
                else if (ikinciSpinnerItem == "centimeters"){
                    result = value / 0.62137 / 1000 / 100
                }
                else if (ikinciSpinnerItem == "millimeters"){
                    result = value / 0.62137 / 1000 / 100 / 10
                }
                else if (ikinciSpinnerItem == "miles"){
                    result = value
                }
            }
            result = "%.3f".format(result).toDouble()
            binding.ikinciDegerPlainText.setText(result.toString())
        }
    }
    }




