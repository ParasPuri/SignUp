package com.example.paras.signup.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.paras.signup.R;

public class SignedIn extends AppCompatActivity {

    TextView tvWelcome;
    Button btnListUSer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);

        tvWelcome = (TextView) findViewById(R.id.tvWelcomeUser);
        btnListUSer = (Button) findViewById(R.id.btnListAllUser);

       // String username = getIntent().getStringExtra("userName");

        btnListUSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent list = new Intent(SignedIn.this,ListUser.class);
                startActivity(list);
            }
        });
    }
}
