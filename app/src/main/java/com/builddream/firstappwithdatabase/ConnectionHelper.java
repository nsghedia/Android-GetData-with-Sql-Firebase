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

    public Connection connection(){ //Replace #### with your configurations
        ip = "####";
        database ="####";
        uname = "####";
        pass = "####";
        port="####";

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
