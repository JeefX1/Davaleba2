package com.example.myfirstcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView= findViewById(R.id.resultTextView)

        findViewById<TextView>(R.id.delbutton).setOnClickListener(){
            val string = resultTextView.text.toString()
            if (string.isNotEmpty()){
                resultTextView.text = string.substring(0, string.length-1)
            }
        }

        findViewById<TextView>(R.id.clearButton).setOnClickListener(){
            resultTextView.text = ""
            operand = 0.0
            operation = ""
        }
    }

    fun numberClick(view: View) {
        if (view is TextView) {
            val number: String = view.text.toString()
            val result: String = resultTextView.text.toString()

            if (result == "0"){
                result ==""
            }

            resultTextView.text= result + number
        }
    }

    fun operationClick(view: View){

        if (view is TextView){

            if (TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }
    }

    fun equalsClick(view: View){

        val secOperand:String = resultTextView.text.toString()
        var secNumber = 0.0

        if (!TextUtils.isEmpty(secOperand)){
            secNumber = secOperand.toDouble()
        }

        when (operation){
            "+" -> resultTextView.text = (operand + secNumber).toString()
            "-" -> resultTextView.text = (operand - secNumber).toString()
            "*" -> resultTextView.text = (operand * secNumber).toString()
            "/" -> resultTextView.text = (operand / secNumber).toString()

        }
    }

}