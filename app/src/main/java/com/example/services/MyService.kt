package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MyService : Service() {

    private var isRunning = false

//    private val job = SupervisorJob()
//    private val scope = CoroutineScope(Dispatchers.IO * job)

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

//        Thread.sleep(10000)

        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()
        BackgroundTask(this).execute(5)

        return START_STICKY
    }

    override fun onDestroy() {
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}