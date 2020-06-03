package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapp.Connection.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Register extends AppCompatActivity {

    Button bRegister;
    EditText etEmployee_ID, etFirst_name, etLast_name, etPhone_Number, etEmail_Address, etGender, etBirth_Date, etLocation, etJob_Name, etPassWord;

    Connection con;
    Statement stmt;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmployee_ID = (EditText) findViewById(R.id.etEmployee_ID);
        etFirst_name = (EditText) findViewById(R.id.etFirst_name);
        etLast_name = (EditText) findViewById(R.id.etLast_name);
        etPhone_Number = (EditText) findViewById(R.id.etPhone_Number);
        etEmail_Address = (EditText) findViewById(R.id.etEmail_Address);
        etGender = (EditText) findViewById(R.id.etGender);
        etBirth_Date = (EditText) findViewById(R.id.etBirth_Date);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etJob_Name = (EditText) findViewById(R.id.etJob_Name);
        etPassWord = (EditText) findViewById(R.id.etPassWord);
        bRegister = (Button) findViewById(R.id.bRegister);
        status = (TextView) findViewById(R.id.bStatus);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Register.registerUser().execute(" ");
            }
        });

    }

    @SuppressLint("NewApi")
    public Connection connectionClass(String user, String password, String database, String server) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc.jtds:sqlserver://" + server + "/" + database + ";use=r" + user + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);

        } catch (Exception e) {
            Log.e("SQL Connection Error: ", e.getMessage());

        }

        return connection;
    }


    public class registerUser extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            status.setText("Sending Data to Database");

        }

        @Override
        protected void onPostExecute(String s) {
            status.setText("Registraton Successful");
            etEmployee_ID.setText("");
            etFirst_name.setText("");
            etLast_name.setText("");
            etPhone_Number.setText("");
            etEmail_Address.setText("");
            etGender.setText("");
            etBirth_Date.setText("");
            etLocation.setText("");
            etJob_Name.setText("");
            etPassWord.setText("");

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                con = connectionClass(ConnectionClass.UserNameSQLserver.toString(), ConnectionClass.passsqlsever.toString(), ConnectionClass.database.toString(), ConnectionClass.ip_addressDataBase.toString());
                if (con == null) {
                    z = "Check your internet Connection";
                } else {
                    String sql = "INSERT INTO app_table (emp_ID,fname,Lname,phone_no,email_add,birth_date,location,job_name,password) VALUES ('" + etEmployee_ID.getText() + "','" + etFirst_name + "', '" + etLast_name.getText() + "', '" + etPhone_Number.getText() + "','" + etEmail_Address.getText() + "','" + etGender.getText() + "','" + etBirth_Date.getText() + "','" + etLocation.getText() + "','" + etJob_Name.getText() + "','" + etPassWord.getText() + "')";
                    stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                }

            } catch (Exception e) {

                isSuccess = false;
                z = e.getMessage();
            }

            return z;

        }
    }
}