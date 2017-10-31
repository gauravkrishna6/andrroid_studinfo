package com.example.gaurav.studinfo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
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
    Button btn_register;
    Button btn_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        OpenHelper =  new DatabaseHelper(this);
        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtPassword = (TextView)findViewById(R.id.txtPwd);
        txtConPass = (TextView)findViewById(R.id.txtConfirmPwd);
        btn_register = (Button)findViewById(R.id.btnReg);
        btn_login = (Button)findViewById(R.id.btnLogin);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = OpenHelper.getWritableDatabase();

                String Name = txtName.getText().toString();
                String Email = txtEmail.getText().toString();
                String Password = txtPassword.getText().toString();
                String ConfirmPassword = txtConPass.getText().toString();

                if(Password.equals(ConfirmPassword)){
                    db.execSQL("INSERT INTO admin_details(name,email,password) VALUES('"+Name+"','"+Email+"','"+Password+"')");
                  // insertRegData(Name,Email,Password);
                    Toast.makeText(getApplicationContext(),"Registered Successfully !! ",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Passwords don't match",Toast.LENGTH_LONG).show();
                }


            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this , LoginActivity.class);
                startActivity(intent);

            }
        });


    }

//    public void  insertRegData(String name, String email,String pwd){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.COL_1,name);
//        contentValues.put(DatabaseHelper.COL_2,5);
//        contentValues.put(DatabaseHelper.COL_3,5);
//        contentValues.put(DatabaseHelper.COL_4,5);
//
//    }

}
