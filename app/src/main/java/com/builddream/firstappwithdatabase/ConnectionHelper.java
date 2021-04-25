package com.builddream.firstappwithdatabase;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String uname,pass,ip,port,database;
    @SuppressLint("NewApi")

    public Connection connection(){
        ip = "192.168.1.12";
        database ="CBI";
        uname = "sa";
        pass = "chand1997";
        port="1433";

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnURL=null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databasename="+database+";user="+uname+";password="+pass+";";
            connection= DriverManager.getConnection(ConnURL);
        }
        catch (Exception ex)
        {
            Log.e("Error ",ex.getMessage());
        }
        return  connection;
    }
}
