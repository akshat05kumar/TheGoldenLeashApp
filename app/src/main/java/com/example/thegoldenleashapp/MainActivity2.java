package com.example.thegoldenleashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cancelButton();
    }

    private void cancelButton() {
        Button cbutton =(Button) findViewById(R.id.cancelButton);
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




    public static Intent makeIntent(Context context)
    { return new Intent(context, MainActivity2.class);


    }

}