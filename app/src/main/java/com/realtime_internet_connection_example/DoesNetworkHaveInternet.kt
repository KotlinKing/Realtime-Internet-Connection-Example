package com.realtime_internet_connection_example

import android.util.Log
import java.io.IOException
import java.net.InetSocketAddress
import javax.net.SocketFactory

object DoesNetworkHaveInternet {
    fun execute(socketFactory: SocketFactory): Boolean {
        return try{
           // PINGING Google.
            val socket = socketFactory.createSocket() ?: throw IOException("Socket is null.")
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            //  PING Successful.
            true
        }catch (e: IOException){
            //  No internet connection.
            false
        }
    }
}