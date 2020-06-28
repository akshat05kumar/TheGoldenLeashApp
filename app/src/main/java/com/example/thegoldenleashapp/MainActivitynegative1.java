package com.example.thegoldenleashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivitynegative1 extends AppCompatActivity {

    EditText t1, t2, t3, t4, t5, t6, t7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitynegative1);

        t1 = (EditText) findViewById(R.id.Name);
        t2 = (EditText) findViewById(R.id.Gender);
        t3 = (EditText) findViewById(R.id.Age);
        t4 = (EditText) findViewById(R.id.Occupation);
        t5 = (EditText) findViewById(R.id.Address);
        t6 = (EditText) findViewById(R.id.ContactNo);
        t7 = (EditText) findViewById(R.id.SpeciesPrefrence);


    }

   public void RegisterButton(View view) {

        Dbmanager db = new Dbmanager(this);

        String res = db.Register(t1.getText().toString(), t2.getText().toString(), t3.getText().toString(), t4.getText().toString(), t5.getText().toString(), t6.getText().toString(), t7.getText().toString());

        Toast.makeText(this, res, Toast.LENGTH_LONG).show();

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");

       finish();

    }


    public void CancelButton(View view) {

                finish();

    }


    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivitynegative1.class);
    }

}