package com.example.myapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;

    EditText etEmployee_ID,etPassWord;
    TextView tvRegisterlink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegisterlink=(TextView) findViewById(R.id.tvRegisterLink);
        etEmployee_ID=(EditText) findViewById(R.id. etEmployee_ID);
        etPassWord=(EditText) findViewById(R.id.etPassWord);
        bLogin=(Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        tvRegisterlink.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                startActivity(new Intent(this,Login.class));
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this,Register.class));
                break;

        }
    }
}
