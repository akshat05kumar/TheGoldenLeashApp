package com.example.thegoldenleashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ASButton();
       FORButton();
    }

    private void FORButton() {
        Button forButton=(Button) findViewById(R.id.button2);
        forButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivitynegative1.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }


    public void ASButton()
    {
        Button asButton=(Button) findViewById(R.id.button1);
        asButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                Intent intent= MainActivity2.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });
      {

      }

    }

}