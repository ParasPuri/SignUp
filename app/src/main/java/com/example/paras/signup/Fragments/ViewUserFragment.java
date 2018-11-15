package com.example.paras.signup.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paras.signup.Activities.BaseActivity;
import com.example.paras.signup.R;
import com.example.paras.signup.RoomDb.User;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewUserFragment extends Fragment {

    TextView tvViewUsers;

    public ViewUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_user, container, false);

        tvViewUsers = view.findViewById(R.id.tvDisplayUser);

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
        tvViewUsers.setText(info);

        return  view;
    }

}
