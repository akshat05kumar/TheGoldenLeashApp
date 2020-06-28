package com.example.thegoldenleashapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class Dbmanager extends SQLiteOpenHelper {

    public static final String dbName="Register.db";

    public Dbmanager(Context context) {
        super(context, dbName, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String qry="create table tb_AS (id integer primary key autoincrement, name text, Gender text, Age integer, Occupation text, Address text, ContactNo integer, SpeciesPrefrence text )";
       db.execSQL(qry);
        String Qry="create table tb_FOR (id integer primary key autoincrement, Petname text, PetBreed text, PetAge integer,OwnerName text, OwnerAddress text, OwnerContactNo integer)";
        db.execSQL(Qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_AS");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS tb_FOR");
        onCreate(db);
    }

    public String Register(String p1,String p2,String p3,String p4,String p5,String p6,String p7)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("name",p1);
        cv.put("Gender",p2);
        cv.put("Age",p3);
        cv.put("Occupation",p4);
        cv.put("Address",p5);
        cv.put("ContactNo",p6);
        cv.put("SpeciesPrefrence",p7);

        long res=db.insert("tb_AS",null,cv);

        if(res==-1)
            return "Failed";
        else
            return "You Have Successfully Registered as a PET CARER!!!!";

    }

    public String GetpetCare(String q1,String q2,String q3,String q4,String q5,String q6)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("Petname",q1);
        cv.put("PetBreed",q2);
        cv.put("PetAge",q3);
        cv.put("OwnerName",q4);
        cv.put("OwnerAddress",q5);
        cv.put("OwnerContactNo",q6);

        long res=db.insert("tb_FOR",null,cv);

        if(res==-1)
            return "Failed";
        else
            return "Data entered successfully.Markers showing pet caretaker for you !!  ";

    }
}
