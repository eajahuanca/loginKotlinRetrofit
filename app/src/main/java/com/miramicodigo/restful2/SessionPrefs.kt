package com.miramicodigo.restful_2

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.miramicodigo.restful_2.model.Persona

class SessionPrefs constructor(context: Context) {

    private val PREFERENCES_NAME = "PERSONA_PREFERENCES"
    private val PREFERENCES_PERSONA_ID = "PREF_PERSONA_USER_ID"
    private val PREFERENCES_PERSONA_NAME = "PREF_PERSONA_NAME"
    private val PREFERENCES_PERSONA_ADDRESS = "PREF_PERSONA_ADDRESS"
    private val PREFERENCES_PERSONA_GENDER = "PREF_PERSONA_GENDER"
    private val PREFERENCES_PERSONA_TOKEN = "PREF_PERSONA_TOKEN"

    private var mPrefs: SharedPreferences? = null

    private var mIsLoggedIn = false

    lateinit var INSTANCE: SessionPrefs

    fun get(cont: Context): SessionPrefs {
        INSTANCE = SessionPrefs(cont)
        return INSTANCE as SessionPrefs
    }

    init {
        mPrefs = context!!.applicationContext.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        mIsLoggedIn = !TextUtils.isEmpty(mPrefs!!.getString(PREFERENCES_PERSONA_TOKEN, null))
    }

    fun isLoggedIn(): Boolean {
        return mIsLoggedIn;
    }

    fun saveAffiliate(persona: Persona?) {
        if (persona != null) {
            val editor: SharedPreferences.Editor? = mPrefs!!.edit()
            editor!!.putString(PREFERENCES_PERSONA_ID, persona.id)
            editor!!.putString(PREFERENCES_PERSONA_NAME, persona.name)
            editor!!.putString(PREFERENCES_PERSONA_ADDRESS, persona.address)
            editor!!.putString(PREFERENCES_PERSONA_GENDER, persona.gender)
            editor!!.putString(PREFERENCES_PERSONA_TOKEN, persona.token)
            editor!!.apply()
            mIsLoggedIn = true
        }
    }

    fun logOut(){
        mIsLoggedIn = false;
        val editor: SharedPreferences.Editor = mPrefs!!.edit()
        editor.putString(PREFERENCES_PERSONA_ID, null)
        editor.putString(PREFERENCES_PERSONA_NAME, null)
        editor.putString(PREFERENCES_PERSONA_ADDRESS, null)
        editor.putString(PREFERENCES_PERSONA_GENDER, null)
        editor.putString(PREFERENCES_PERSONA_TOKEN, null)
        editor.apply()
    }

    fun getPerson() : Persona {
        var id = mPrefs!!.getString(PREFERENCES_PERSONA_ID, "")
        var name = mPrefs!!.getString(PREFERENCES_PERSONA_NAME, "")
        var address = mPrefs!!.getString(PREFERENCES_PERSONA_ADDRESS, "")
        var gender = mPrefs!!.getString(PREFERENCES_PERSONA_GENDER, "")
        var token = mPrefs!!.getString(PREFERENCES_PERSONA_TOKEN, "")
        return Persona(id, name, address, gender, token)
    }
}
