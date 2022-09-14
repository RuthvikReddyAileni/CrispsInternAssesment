package com.example.notificationsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTitle;
    private EditText editDescription;
    static String message = "";
    static String title = "";
    static int button = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
        editTitle = findViewById(R.id.title);
        editDescription = findViewById(R.id.des);
    }
    public void sendOnChannelA(View v){

        button  = 1;
        title = editTitle.getText().toString();
        message = editDescription.getText().toString();

        if(title.isEmpty()){
            editTitle.setError("Enter title");
            return;
        }if(message.isEmpty()){
            editDescription.setError("Enter Description");
            return;
        }

        Intent activityIntent = new Intent(this,MessageScreen.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0,activityIntent,0);

        Intent broadcastIntent = new Intent(this,NotificationReceiver.class);
        broadcastIntent.putExtra("ToastMessage",message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this,App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_check_box_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .build();

        notificationManager.notify(1,notification);

    }
    public void sendOnChannelB(View v){
        button = 2 ;
        title = editTitle.getText().toString();
        message = editDescription.getText().toString();


        Intent activityIntent = new Intent(this,MessageScreen.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0,activityIntent,0);

        Intent broadcastIntent = new Intent(this,NotificationReceiver.class);
        broadcastIntent.putExtra("ToastMessage",message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this,App.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_indeterminate_check_box_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setColor(Color.RED)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .build();

        notificationManager.notify(2 ,notification);
    }
}