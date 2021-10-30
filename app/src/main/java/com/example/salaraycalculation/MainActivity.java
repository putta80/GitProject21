package com.example.salaraycalculation;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
public class MainActivity extends AppCompatActivity
{
    DatabaseHelper myDb;
    EditText edName, edID, edNum, edEmail, edSal, edBeni, edTsal;
    Button btnTotal, btnAdd, btnDel, btnUpdate, btnView, btnClear;

    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        edName = (EditText) findViewById(R.id.edName);
        edID = (EditText) findViewById(R.id.edID);
        edNum = (EditText) findViewById(R.id.edID);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edSal = (EditText) findViewById(R.id.edSal);
        edBeni = (EditText) findViewById(R.id.edBen);
        edTsal = (EditText) findViewById(R.id.edTsal);

        btnTotal = (Button) findViewById(R.id.btnAdd);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnView = (Button) findViewById(R.id.btnView);
        btnClear = (Button) findViewById(R.id.btnClear);

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.edName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.edEmail, Patterns.EMAIL_ADDRESS, R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.edNum, "^[2-9]{2}[0-9]{8}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.edSal, "^[2-9]{2}[0-9]{8}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.edBen, "^[2-9]{2}[0-9]{8}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.edID, "^[2-9]{2}[0-9]{8}$", R.string.nameerror);

        CalculateTotal();
        Add();
        Update();
        Delete();
        ViewAll();
        Clear();
    }

    public void CalculateTotal() {
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //block of code goes here

                //input field validation code here
                if (awesomeValidation.validate()) {
                    //process the data further
                }
            }
        });
    }
    public void Add() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //block of code goes here
            }
        });
    }
    public void Update() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //block of code goes here
            }
        });
    }
    public void Delete() {
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //block of code goes here
            }
        });
    }
    public void ViewAll()
    {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //block of code goes here
            }
        });
    }
    public void Clear()
    {
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //block of code goes here
            }
        });
    }
}