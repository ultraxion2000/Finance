package com.dorrrke.finanseproject.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dorrrke.finanseproject.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {
            if (textUsername.text.trim()
                    .isNotEmpty() && FIO.text.isNotEmpty() && textMobile.text.isNotEmpty() && textEmail.text.isNotEmpty()
            ) {
                Toast.makeText(this, "Account created", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }
        }
        tvLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java);
            startActivity(intent);
        }
    }
}