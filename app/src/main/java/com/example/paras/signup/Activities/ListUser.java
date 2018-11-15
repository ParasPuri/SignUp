package com.example.paras.signup.Activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paras.signup.Activities.BaseActivity;
import com.example.paras.signup.R;
import com.example.paras.signup.RoomDb.User;

import java.util.ArrayList;
import java.util.List;

public class ListUser extends AppCompatActivity {
    TextView lvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        lvUser = (TextView) findViewById(R.id.tvListUser);

        List<User> users = BaseActivity.myAppDatabase.userDao().getUsers();

        String info = "";

        for(User usr : users)
        {
            String userName = usr.getName();
            String userAddress = usr.getAddress();
            String userEmail = usr.getEmail();
            String userNumber= usr.getNumber();
            String userPassword = usr.getPassword();

            info = info+"\n\n"+"Name :"+userName+"\nAddress :"+userAddress+"\nEmail :"+userEmail+"\nNumber: "+userNumber
                    +"\nPassword :"+userPassword;

        }
        lvUser.setText(info);


    }
        }

