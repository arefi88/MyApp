package com.example.myapplication.loginapp

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var edtUserName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSingUp: Button

    private val userName=""
    private val userPassword=""
    private lateinit var ac:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        ac=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode== RESULT_OK){
                val userName= it.data?.getStringExtra("USERNAME")
                val userPassword= it.data?.getStringExtra("PASSWORD")
                edtUserName.setText(userName)
                edtPassword.setText(userPassword)
            }else{
                Toast.makeText(this,"no",Toast.LENGTH_SHORT).show()
            }
        }
//        val userName = intent?.getStringExtra("userName")
//        val password = intent?.getStringExtra("password")
//
//        edtUserName.setText(userName)
//        edtPassword.setText(password)

        btnLogin.setOnClickListener {
            ac.launch(SignUpActivity.newIntent(this@LoginActivity,edtUserName.text.toString(),edtPassword.text.toString()))

            if (edtUserName.text.toString() == userName && edtPassword.text.toString() == userPassword) {

                val snack = Snackbar.make(it, "login successfully", Snackbar.LENGTH_SHORT)
                snack.show()

            } else {
                Toast.makeText(applicationContext, "not match!!!", Toast.LENGTH_SHORT).show()
            }

        }
        btnSingUp.setOnClickListener {
//            val signUpActivityIntent = Intent(this, SignUpActivity::class.java)
//            signUpActivityIntent.putExtra("user", edtUserName.text.toString())
//            signUpActivityIntent.putExtra("pass", edtPassword.text.toString())
//            startActivity(signUpActivityIntent)
            ac.launch(SignUpActivity.newIntent(this@LoginActivity,edtUserName.text.toString(),edtPassword.text.toString()))
        }
    }


    private fun init() {
        edtUserName = findViewById(R.id.edt_username)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btn_login)
        btnSingUp = findViewById(R.id.btin_signup)


    }
}