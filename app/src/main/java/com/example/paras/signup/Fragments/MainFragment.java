package com.example.paras.signup.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.paras.signup.Activities.BaseActivity;
import com.example.paras.signup.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    Button btnSignUp,btnView;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        btnSignUp = view.findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);

        btnView = view.findViewById(R.id.btnViewUser);
        btnView.setOnClickListener(this);


        return  view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnSignUp:
                BaseActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SignUpFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.btnViewUser:
                BaseActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ViewUserFragment())
                        .addToBackStack(null).commit();
        }

    }
}
