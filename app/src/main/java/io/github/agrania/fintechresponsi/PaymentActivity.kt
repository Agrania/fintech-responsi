package io.github.agrania.fintechresponsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PaymentActivity : AppCompatActivity() {

    private lateinit var etPay: EditText
    private lateinit var BtnPay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        etPay = findViewById(R.id.et_pay)
        BtnPay.setOnClickListener {
            val email = etPay.text.toString()
        }
    }
}