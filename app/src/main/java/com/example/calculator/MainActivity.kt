package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""
    var c: Int = 0
    var a: String = ""
    var b: Float = 1.5F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(clickedView: View) {

        if (clickedView is Button) {

            val number: String = clickedView.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = "$result$number"

        }

    }

    fun operationClick(view: View) {

        if (view is Button) {

            if (resultTextView.text.isNotEmpty()) {
                operand = resultTextView.text.toString().toDouble()
            }

            operation = view.text.toString()

            resultTextView.text = ""

        }

    }

    fun equalsClick(view: View) {

        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()) {
            secOperand = secOperandText.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
        }
        this.a = this.resultTextView.text.toString()
        this.b = this.a.toFloat()
        this.c = b.roundToInt()


        if(this.b % 1 == 0F ) {
            this.resultTextView.text = this.c.toString()
        }



    }
    fun clearClick(view: View) {
        if (view is Button) {
            resultTextView.text = ""
        }
    }
    fun delClick(view: View) {
        val washale = resultTextView.text.toString()
        if (washale.isNotEmpty()) {
            if (view is Button) {
                resultTextView.text = washale.substring(0, washale.length - 1)
            }
        }
    }

}