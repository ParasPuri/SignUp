package com.example.paras.signup;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.paras.signup.RoomDb.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public  void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();
}
