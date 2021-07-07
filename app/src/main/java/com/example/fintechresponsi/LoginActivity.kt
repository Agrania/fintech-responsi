package com.example.fintechresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        BtnLogin.setOnClickListener {
            val intentLogin = Intent(this, RegisterActivity::class.java)
            startActivity(intentLogin)
        }

        tvRegister.setOnClickListener {
           val intentReg = Intent(this, RegisterActivity::class.java)
            startActivity(intentReg)
        }

        tvForgotPassword.setOnClickListener {
            val intentPass = Intent(this, RegisterActivity::class.java)
            startActivity(intentPass)
        }
    }
}