package com.realtime_internet_connection_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.realtime_internet_connection_example.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var connectionLiveData: ConnectionLiveData
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //checking internet status
        connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this, { isNetworkAvailable ->
            if(isNetworkAvailable){
                //internet connected!
                txtInternetCheck.text = resources.getString(R.string.txtinternet)
                txtInternetCheckSubTitle.text = resources.getString(R.string.internet_connected_sub_text)
            }else{
                //internet disconnected!
                txtInternetCheck.text = resources.getString(R.string.txtnointernet)
                txtInternetCheckSubTitle.text = resources.getString(R.string.internet_sub_text)
            }
        })
    }
}