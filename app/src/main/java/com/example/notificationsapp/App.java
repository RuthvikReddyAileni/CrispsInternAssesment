package com.example.notificationsapp;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID = "channelA";
    public static final String CHANNEL_2_ID = "channelB";
    @Override
    public void onCreate(){
        super.onCreate();
        createNotificationChannels();
    }
    private void createNotificationChannels(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel A",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is from Channel A");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel B",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel1.setDescription("This is from Channel B");

            NotificationManager manager =  getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}
