package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btn_calculate = findViewById<Button>(R.id.btn_calculate)


        btn_calculate.setOnClickListener {

            val weightStr: String = edtWeight.text.toString()
            val heightStr: String = edtHeight.text.toString()

            if (weightStr == "" || heightStr == ""){
                Snackbar
                    .make(
                        edtWeight,
                        "Fill up all the boxes",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else{
                val weightPerson = weightStr.toFloat()
                val heightPerson = heightStr.toFloat()

                val height2 = heightPerson * heightPerson
                val result = weightPerson / height2


                // navigate next screen
                // create layout next screen
                // forward the data to the next screen

                // Intent - Android Class

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_BMI, result)
                startActivity(intent)
            }


        }





    }
}
