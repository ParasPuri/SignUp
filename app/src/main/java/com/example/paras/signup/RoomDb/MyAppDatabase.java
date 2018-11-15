package com.example.paras.signup.RoomDb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.paras.signup.RoomDb.User;
import com.example.paras.signup.UserDao;

@Database(entities = {User.class}, version = 3)
public abstract class MyAppDatabase extends RoomDatabase {

    public  abstract UserDao userDao();


}
