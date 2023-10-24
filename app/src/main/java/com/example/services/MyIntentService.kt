package com.example.services

import android.app.IntentService
import android.content.Intent
import android.widget.Toast

const val MY_ACTION = "com.example.services.action.MY_ACTION"
const val INT_EXTRA = "com.example.services.action.INT_EXTRA"

class MyIntentService : IntentService("MyIntentService") {

    private val handler = android.os.Handler()
    override fun onHandleIntent(intent: Intent?) {

        when (intent?.action) {
            MY_ACTION -> {
                val taskCount = intent.getIntExtra(INT_EXTRA, 0)
                handleTasks(taskCount)
            }
        }
    }

    private fun handleTasks(taskCount: Int) {
        for (i in 0 until taskCount) {
            Thread.sleep(3000)
// Može se rješavati s korutinom i s hendlerom
            handler.post {
                Toast.makeText(
                    applicationContext,
                    "${i + 1} of $taskCount tasks finished in background",
                    Toast.LENGTH_SHORT
                ).show()
            }

            }
        }
    }