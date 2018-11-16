package com.example.paras.signup.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paras.signup.Activities.BaseActivity;
import com.example.paras.signup.Activities.SignedIn;
import com.example.paras.signup.R;
import com.example.paras.signup.RoomDb.User;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private static final Pattern Password_Pattern =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*).{8,15}$");
    private static final Pattern PhnNumber_Pattern = Pattern.compile("^([0-9]){10,12}$");

    EditText etName, etAddress, etEmail, etNumber, etPassword;
    String userName, userAddress, userEmail, userNumber, userPassword;

    Button btnSave;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        etName = view.findViewById(R.id.etName);
        etAddress = view.findViewById(R.id.etAddress);
        etEmail = view.findViewById(R.id.etEmail);
        etNumber = view.findViewById(R.id.etNumber);
        etPassword = view.findViewById(R.id.etPassword);
        btnSave = view.findViewById(R.id.btnSave);

       // btnSave.setVisibility(View.VISIBLE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        return view;
    }

    public void register() {
        initialize();
        if (!validate()) {
            Toast.makeText(getActivity(), "SignUp failed", Toast.LENGTH_LONG).show();
        } else {
            String userName = etName.getText().toString();
            String userAddress = etAddress.getText().toString();
            String userEmail = etEmail.getText().toString();
            String userNumber = etNumber.getText().toString();
            String userPassword = etPassword.getText().toString();

            User user = new User();
            user.setName(userName);
            user.setAddress(userAddress);
            user.setEmail(userEmail);
            user.setNumber(userNumber);
            user.setPassword(userPassword);

            BaseActivity.myAppDatabase.userDao().addUser(user);
            Toast.makeText(getActivity(), "SignUp Successful", Toast.LENGTH_LONG).show();

            etName.setText("");
            etAddress.setText("");
            etEmail.setText("");
            etNumber.setText("");
            etPassword.setText("");

            getActivity().getSupportFragmentManager().popBackStack();

            Intent i = new Intent(getActivity(), SignedIn.class);
            i.putExtra("userName",etName.getText().toString());
            startActivity(i);

        }
    }

    public boolean validate() {
        boolean valid = true;
        if (userName.isEmpty() || userName.length() < 4) {
            etName.setError("Please Enter Valid Name");
            valid = false;
        }
        if (userAddress.isEmpty() || userAddress.length() < 10) {
            etAddress.setError("Please Enter Valid Address");
            valid = false;
        }
        if (userEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            etEmail.setError("Please enter valid Email");
            valid = false;
        }
        if (userNumber.length() < 10 || !PhnNumber_Pattern.matcher(userNumber).matches()) {
            etNumber.setError("Please Enter Valid Phone Number");
            valid = false;
        }
        if (userPassword.isEmpty() || !Password_Pattern.matcher(userPassword).matches()) {
            etPassword.setError("Please Enter Valid Password");
           // btnSave.setVisibility(View.INVISIBLE);
            //etPassword.addTextChangedListener(signUpTextWatcher);
            valid = false;
        }
        return valid;
    }

    public void initialize() {
        userName = etName.getText().toString();
        userAddress = etAddress.getText().toString();
        userEmail = etEmail.getText().toString();
        userNumber = etNumber.getText().toString();
        userPassword = etPassword.getText().toString();
    }
}



//    public TextWatcher signUpTextWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            userName = etName.getText().toString();
//            userAddress = etAddress.getText().toString();
//            userEmail = etEmail.getText().toString();
//            userNumber = etNumber.getText().toString();
//            userPassword = etPassword.getText().toString();
//
//            btnSave.setEnabled(!userName.isEmpty() && !userAddress.isEmpty() && !userEmail.isEmpty()
//                    && !userNumber.isEmpty() && !userPassword.isEmpty());
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//
//        }
//    };



