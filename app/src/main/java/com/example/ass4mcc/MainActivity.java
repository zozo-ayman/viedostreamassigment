package com.example.ass4mcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.video1);
        button2=findViewById(R.id.video2);
        button3=findViewById(R.id.video3);
        button4=findViewById(R.id.video4);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("https://firebasestorage.googleapis.com/v0/b/cloudproject-72876.appspot.com/o/Containers%20%26%20Contents-%20English%20Vocabulary%20Lesson.mp4?alt=media&token=1741d533-356c-46b5-940d-04942f8f8560");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("https://firebasestorage.googleapis.com/v0/b/cloudproject-72876.appspot.com/o/Containers%20and%20quantities-%20English%20Language.mp4?alt=media&token=4c8d43d3-d01c-4ac1-9aae-7764b8280d59");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("https://firebasestorage.googleapis.com/v0/b/cloudproject-72876.appspot.com/o/English%20Vocabulary%20-%20Food%20containers.mp4?alt=media&token=7278b2c2-dbc0-415e-a154-02711243b9e1");

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent("https://firebasestorage.googleapis.com/v0/b/cloudproject-72876.appspot.com/o/containers%20and%20quantities.mp4?alt=media&token=5978a23d-06c2-4bb1-bc9e-008827ac6028");

            }
        });

    }
    public  void intent(String url){
        Intent i =new Intent(this,VideoDisplayActivity.class);
        i.putExtra("Url",url);
        startActivity(i);
    }
    }
