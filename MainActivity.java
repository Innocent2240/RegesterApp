package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogOut;
    EditText etLast_name,etFirst_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLast_name =(EditText) findViewById(R.id.etLast_name) ;
        etFirst_name=(EditText) findViewById(R.id.etFirst_name) ;
        bLogOut=(Button) findViewById(R.id.bLogOut) ;
        bLogOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogOut:
                startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
