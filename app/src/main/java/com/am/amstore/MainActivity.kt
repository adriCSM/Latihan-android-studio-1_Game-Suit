package com.am.amstore

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var loginTextView:TextView
    private lateinit var brandTextView: TextView
    private fun initComponents(){
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        loginTextView = findViewById(R.id.loginTextView)
        brandTextView = findViewById(R.id.brandTextView)
    }

    private fun chackFingerprint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE","Have Feature Fingerprint")
        }else{
            Log.i("FEATURE","Dont Have Feature Fingerprint")
        }
    }

    private fun checkSdkVersion(){
       Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N_MR1){
            Log.i("SDK", "Versi Nugget 7.1.1 atau UP")
        }else{
            Log.i("SDK", "Dibawah Versi Nugget 7.1.1")
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()

        brandTextView.text=resources.getString(R.string.app_name)
        loginButton.setBackgroundColor(resources.getColor(R.color.background,theme))

        loginButton.setOnClickListener{

            chackFingerprint()
            checkSdkVersion()

            val username=usernameEditText.text.toString()
            val password=passwordEditText.text.toString()

//            loginTextView.text=resources.getString(R.string.loginTextView,username,password)
//            val json=assets.open("data.json") atau

            val json=resources.openRawResource(R.raw.data)
                .bufferedReader()
                .use { it.readText() }
            Log.i("JSON",json)
            loginTextView.text=json
        }
    }
}