package com.builddream.firstappwithdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Connection connect;
    String ConnectionResult="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void GetTextFromSQL(View v){
        TextView txt1 = (TextView) findViewById(R.id.textView);
        TextView txt2 = (TextView) findViewById(R.id.textView2);

        try {
            ConnectionHelper connectionHelper=new ConnectionHelper();
            connect = connectionHelper.connection();
            if(connect!=null)
            {
                String q="Select * from AGENTS";
                Statement str=connect.createStatement();
                ResultSet rs= str.executeQuery(q);
                while (rs.next()){
                    txt1.setText(rs.getString(2));
                    txt2.setText(rs.getString(3));
                }
            }
        }
        catch (Exception ex){
            ConnectionResult="Check Connection";

            Log.e("Error ", ex.getMessage());
        }
    }
}