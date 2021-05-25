package com.national.testhilt.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.security.AccessControlContext
import javax.inject.Inject

class Network

@Inject
constructor(val context: Context) : NetworkConnectivity{
    override fun getNetworkInfo(): NetworkInfo? {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as  ConnectivityManager
        return cm.activeNetworkInfo
    }

    override fun isConnected(): Boolean {
        val info = getNetworkInfo()
        return info !=null && info.isConnected
    }

}
