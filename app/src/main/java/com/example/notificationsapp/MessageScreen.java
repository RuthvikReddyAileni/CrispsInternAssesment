package com.example.notificationsapp;

import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MessageScreen extends AppCompatActivity {

    TextView textView,textView1,disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_screen);
        textView = findViewById(R.id.message2);
        textView1 = findViewById(R.id.message1);
        disp = findViewById(R.id.message3);
        if(MainActivity.button==2){
            disp.setVisibility(VISIBLE);
        }
        textView1.setText(MainActivity.title);
        textView.setText(MainActivity.message);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}