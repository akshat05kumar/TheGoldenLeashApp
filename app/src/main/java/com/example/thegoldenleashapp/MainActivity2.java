package com.example.thegoldenleashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText s1,s2,s3,s4,s5,s6;
    private int radius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        attachSeekBarListener();
        registerButton();
        cancelButton();

        s1 = findViewById(R.id.name1);
        s2 = findViewById(R.id.Breeds);
        s3 = findViewById(R.id.PetAge);
        s4 = findViewById(R.id.name2);
        s5 = findViewById(R.id.Address1);
        s6 = findViewById(R.id.Number2);
    }

    private void cancelButton() {
        Button cbutton = findViewById(R.id.cancelButton);
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void registerButton(){
        Button rbutton  = (Button) findViewById(R.id.button10);
        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmSearch(v);
                Intent intent = new Intent(MainActivity2.this,MapActivity.class);
                intent.putExtra("radius",radius);
                startActivity(intent);
            }
        });
    }

    private boolean checkFields(){
        return  s1.getText().length()>0 ||
                s2.getText().length()>0 ||
                s3.getText().length()>0 ||
                s4.getText().length()>0 ||
                s5.getText().length()>0 ||
                s6.getText().length()>0 ;
    }
    public void ConfirmSearch(View view)
    {
        Dbmanager db = new Dbmanager(this);

        String res = db.GetpetCare(s1.getText().toString(), s2.getText().toString(), s3.getText().toString(), s4.getText().toString(), s5.getText().toString(), s6.getText().toString());

        if(checkFields()) {
            Toast.makeText(this, res, Toast.LENGTH_LONG).show();
            s1.setText("");
            s2.setText("");
            s3.setText("");
            s4.setText("");
            s5.setText("");
            s6.setText("");
        }
        else{
            Toast.makeText(this,"Some Fields are Empty!!",Toast.LENGTH_SHORT).show();
        }
    }

    public static Intent makeIntent(Context context)
    {
        return new Intent(context, MainActivity2.class);
    }

    private void attachSeekBarListener()
    {
        SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView seekBar_Progress = findViewById(R.id.seekBarProgress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                radius = 2+progress/25;
                seekBar_Progress.setText(String.format("%.2f",(2.0+progress/25.0)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }
}