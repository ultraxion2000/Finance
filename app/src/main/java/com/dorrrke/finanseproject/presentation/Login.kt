package com.dorrrke.finanseproject.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dorrrke.finanseproject.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            if (edUsername.text.toString() == "admin" && edMobile.text.toString() == "8111111111") {
                Toast.makeText(this, "Input provided", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent)
            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }
        }
        tvRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java);
            startActivity(intent)
        }
    }

}