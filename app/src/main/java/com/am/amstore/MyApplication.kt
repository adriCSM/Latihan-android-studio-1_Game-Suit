package com.am.amstore

import android.app.Application
import android.util.Log

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("ADRI","My Application is Created")
    }
}