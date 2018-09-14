package com.miramicodigo.restful_2.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.miramicodigo.restful_2.R
import com.miramicodigo.restful_2.SessionPrefs
import com.miramicodigo.restful_2.model.Persona
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!SessionPrefs(this).get(this).isLoggedIn()){
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
            return
        }
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val persona = SessionPrefs(this).get(this).getPerson() as Persona
        tvNombre.text = persona.name
        tvUsuario.text = persona.id
        tvDireccion.text = persona.address
        tvGenero.text = if(persona.gender == "M") "Masculino" else "Femenino"

        fab.setOnClickListener{
            SessionPrefs(this).get(this).logOut()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}