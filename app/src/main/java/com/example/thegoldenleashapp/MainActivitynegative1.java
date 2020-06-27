package com.example.thegoldenleashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivitynegative1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitynegative1);

        RegisterButton();
        CancelButton();
    }

    private void RegisterButton() {
        Button registerButton =(Button) findViewById(R.id.buttonNeg2);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowToast();
                finish();
            }
        });
    }

    private void ShowToast() {
        Toast.makeText(MainActivitynegative1.this, "You Have Successfully Registered as a PET CARER!!!!", Toast.LENGTH_SHORT).show();
    }

    private void CancelButton() {
        Button cancelButton = (Button) findViewById(R.id.buttonNeg1);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public static Intent makeIntent(Context context) {
        return new Intent(context,MainActivitynegative1.class);
    }
}