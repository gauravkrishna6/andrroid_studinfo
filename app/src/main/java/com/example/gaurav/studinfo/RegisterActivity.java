package com.example.gaurav.studinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    SQLiteOpenHelper OpenHelper;
    SQLiteDatabase db;
    TextView txtName;
    TextView txtEmail;
    TextView txtPassword;
    TextView txtConPass;
    Button reg_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        OpenHelper =  new DatabaseHelper(this);
        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtPassword = (TextView)findViewById(R.id.txtPwd);
        txtConPass = (TextView)findViewById(R.id.txtConfirmPwd);
        reg_button = (Button)findViewById(R.id.btnReg);

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = OpenHelper.getWritableDatabase();
                String Name = txtName.getText().toString();
                String Email = txtEmail.getText().toString();
                String Password = txtPassword.getText().toString();
                String ConfirmPassword = txtConPass.getText().toString();

                if(Password.equals(ConfirmPassword)){
                    insertRegData(Name,Email,Password);
                    Toast.makeText(getApplicationContext(),"successfully registered",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Passwords dont match",Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    public void  insertRegData(String name, String email,String pwd){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,name);
        contentValues.put(DatabaseHelper.COL_3,email);
        contentValues.put(DatabaseHelper.COL_4,pwd);

    }

}
