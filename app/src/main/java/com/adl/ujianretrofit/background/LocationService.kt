package com.adl.ujianretrofit.background

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.location.Location
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.adl.ijin.utility.LocationHelper
import com.adl.ijin.utility.MyLocationListener
import com.adl.ujianretrofit.R
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.security.auth.callback.Callback

class LocationService : Service() {

    companion object{
        var mLocation: Location?=null
        var isServiceStarted = false
    }

    private val NOTIFICATION_CHANNEL_ID = "notifikasi channel"
    private val TAG = "LOCATION_SERVICE"

    override fun onCreate() {
        super.onCreate()
        isServiceStarted = true
        val builder : NotificationCompat.Builder = NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID)
            .setOngoing(false)
            .setSmallIcon(R.drawable.ic_launcher_background)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationManager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID,NOTIFICATION_CHANNEL_ID,NotificationManager.IMPORTANCE_LOW)

            notificationChannel.description = NOTIFICATION_CHANNEL_ID
            notificationChannel.setSound(null,null)
            notificationManager.createNotificationChannel(notificationChannel)
            startForeground(1,builder.build())

        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        LocationHelper().startListeningUserLocation(this,object :MyLocationListener{
            override fun onLocationChanged(location: Location) {
                if (isServiceStarted){
                mLocation = location
                mLocation?.let {
                }
                }
            }
        })
        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {

        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        isServiceStarted = false
    }
}