package com.example.paras.signup.Activities;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.paras.signup.Fragments.MainFragment;
import com.example.paras.signup.RoomDb.MyAppDatabase;
import com.example.paras.signup.R;

public class BaseActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userDB").fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new MainFragment()).commit();
        }

    }
}
