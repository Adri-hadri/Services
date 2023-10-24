package com.example.services

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast


class BackgroundTask(private val context: Context) :
    AsyncTask<Int?, Int?, String>() {

    override fun doInBackground(vararg params: Int?): String {
        val taskCount = params[0] ?: 0
        for (i in 0 until taskCount) {
            Log.i("TEST", i.toString())
            Thread.sleep(3000) // Task se odvija u backgroundu threadu
            publishProgress((((i + 1) / taskCount.toDouble()) * 100).toInt())
        }
        return "$taskCount finished"
    }

    override fun onProgressUpdate(vararg progress: Int?) {
//        Poziva se na UI threadu.
//        Kad je gotov onda pošalje svoj rezultat.
//        Ne ometa korisnika da izvršava druge akcije.
        val text = "${progress[0]} % finished"
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onPostExecute(result: String) {
        Toast.makeText(
            context,
            result,
            Toast.LENGTH_SHORT
        ).show()
    }
}
