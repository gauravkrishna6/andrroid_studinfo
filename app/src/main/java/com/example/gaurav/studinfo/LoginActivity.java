package com.example.gaurav.studinfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    TextView txtLogEmail;
    TextView txtLogPwd;
    Button btnmyLogin;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        txtLogEmail = (TextView)findViewById(R.id.txtLogEmail);
        txtLogPwd = (TextView)findViewById(R.id.txtLogPwd);
        btnmyLogin = (Button)findViewById(R.id.btnmyLogin);

        btnmyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String logEmail = txtLogEmail.getText().toString();
                String logPwd = txtLogPwd.getText().toString();
                cursor = db.rawQuery("SELECT * FROM "+ DatabaseHelper.TABLE_NAME+ " WHERE "+ DatabaseHelper.COL_3 + " ='"+logEmail+ "' AND "+ DatabaseHelper.COL_4+ " = '"+logPwd+"'",null);

                if(cursor!= null){
                    if(cursor.getCount()>0){
                        Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_LONG).show();

                    }
                    else {
                        //int t = cursor.getCount();
                        //String m = Integer.toString(t);
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
