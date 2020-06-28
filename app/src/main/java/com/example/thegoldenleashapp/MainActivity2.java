package com.example.thegoldenleashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText s1,s2,s3,s4,s5,s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        s1=(EditText) findViewById(R.id.name1) ;
        s2=(EditText) findViewById(R.id.Breeds);
        s3=(EditText) findViewById(R.id.PetAge);
        s4=(EditText) findViewById(R.id.name2) ;
        s5=(EditText) findViewById(R.id.Address1);
        s6=(EditText) findViewById(R.id.Number2);

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



    public void ConfirmSearch(View view)
    {
        Dbmanager db = new Dbmanager(this);

        String res = db.GetpetCare(s1.getText().toString(), s2.getText().toString(), s3.getText().toString(), s4.getText().toString(), s5.getText().toString(), s6.getText().toString());

        Toast.makeText(this, res, Toast.LENGTH_LONG).show();

        s1.setText("");
        s2.setText("");
        s3.setText("");
        s4.setText("");
        s5.setText("");
        s6.setText("");




    }




    public static Intent makeIntent(Context context)
    { return new Intent(context, MainActivity2.class);


    }

}