package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_BMI = "ResultActivity.KEY_BMI"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(KEY_RESULT_BMI, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()
        tvClassification.text = classificationBMI(result)



    }

    private fun classificationBMI(bmiResult:Float): String{
        return if (bmiResult <= 18.5f){
            "Underweight"
        }else if(bmiResult <= 24.9f){
            "Healthy Range"
        }else if(bmiResult <= 29.9f){
            "Overweight"
        }else if(bmiResult <= 39.9f){
            "Obesity"
        }else{
            "Severe Obesity"
        }
    }
}