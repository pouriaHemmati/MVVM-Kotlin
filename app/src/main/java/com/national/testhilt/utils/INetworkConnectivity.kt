package com.national.testhilt.utils

import android.net.NetworkInfo

interface INetworkConnectivity {
    fun getNetworkInfo() : NetworkInfo?
    fun isConnected() : Boolean
}

