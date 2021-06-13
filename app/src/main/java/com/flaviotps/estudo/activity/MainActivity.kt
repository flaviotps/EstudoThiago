package com.flaviotps.estudo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.flaviotps.estudo.R

class MainActivity : AppCompatActivity() {

    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var btnEnter : Button

    private fun login(emailRecebido: String, passwordRecebido: String) : Boolean{
        return emailRecebido == "thiago@gmail.com" && passwordRecebido == "12345"
    }

    fun entrarNaTelaPrincipal(){
        val intent = Intent(this, TelaLogada::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnEnter = findViewById(R.id.btnEntrar)

        btnEnter.text = getString(R.string.btnEnter)
        btnEnter.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if(login(emailRecebido = email, passwordRecebido = password)){
                entrarNaTelaPrincipal()
            }else{
                Toast.makeText(this, "Falhou ao logar", Toast.LENGTH_LONG).show()
            }
        }
    }
}