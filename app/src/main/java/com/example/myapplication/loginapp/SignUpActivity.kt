package com.example.myapplication.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SignUpActivity : AppCompatActivity() {
    private lateinit var edtUserName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSingUp: Button
    private var userName = ""
    private var password = ""
    companion object {
        private val userNameTag: String by lazy {
            SignUpActivity::class.java.name + "username"
        }
        private val passwordTag: String by lazy {
            SignUpActivity::class.java.name + "password"
        }

        fun newIntent(context:Context, userName: String?,password:String?):Intent {
            return Intent(context,SignUpActivity::class.java).apply {
                putExtra(userNameTag,userName)
                putExtra(passwordTag,password)
            }
        }
    }

    private lateinit var outputDataUserName: String
    private lateinit var outputDataPassword: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        init()
        val inputUserName=intent.getStringExtra(userNameTag)
        val inputPassword=intent.getStringExtra(passwordTag)


        btnSingUp.setOnClickListener {

            setResult(RESULT_OK,Intent().apply {
                putExtra("USERNAME",edtUserName.text.toString())
                putExtra("PASSWORD",edtPassword.text.toString())
            })
            finish()

        }

        edtUserName.setText(inputUserName)
        edtPassword.setText(inputPassword)

    }

    private fun init() {
        edtUserName = findViewById(R.id.edt_user)
        edtPassword = findViewById(R.id.edt_pass)
        btnSingUp = findViewById(R.id.btn_sign)
    }

}