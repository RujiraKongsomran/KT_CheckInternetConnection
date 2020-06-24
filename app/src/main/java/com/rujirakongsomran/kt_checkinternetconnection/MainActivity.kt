package com.rujirakongsomran.kt_checkinternetconnection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Let's create our connection manager
        val connectionManager: ConnectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        // Let's check the connection and display the info in our layout
        if (isConnected) {
            ivImageStatus.setImageResource(R.drawable.ic_wifi_connect)
            tvStatus.text = "You are connected to the internet"
        }else{
            ivImageStatus.setImageResource(R.drawable.ic_wifi_dis)
            tvStatus.text = "You are not connected to the internet"
        }

        // Let's create the button event function
        btnCheck.setOnClickListener {
            val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

            if (isConnected) {
                ivImageStatus.setImageResource(R.drawable.ic_wifi_connect)
                tvStatus.text = "You are connected to the internet"
            }else{
                ivImageStatus.setImageResource(R.drawable.ic_wifi_dis)
                tvStatus.text = "You are not connected to the internet"
            }
        }
    }
}