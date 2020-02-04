package com.example.appdemo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment  implements View.OnClickListener {

    private EditText txtUername, txtPassword;
    private Button btnLogin;
    private TextView create_account;
    CallbackFragment callbackFragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String userName,password;

    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("usersFile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();



        super.onAttach(context);
    }

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        txtUername = view.findViewById(R.id.edittext_username);
        txtPassword = view.findViewById(R.id.edittext_password);
        btnLogin = view.findViewById(R.id.button_login);
        create_account = view.findViewById(R.id.textview_register);
        create_account.setOnClickListener(this);
        btnLogin = view.findViewById(R.id.button_login);
        btnLogin.setOnClickListener(this);



        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = txtUername.getText().toString();
                password = txtPassword.getText().toString();
                String uName, uPass;
                uName = sharedPreferences.getString("userName", null);
                uPass = sharedPreferences.getString("password", null);
                Log.d("username,password", "onClick: " + uName + "  " + uPass);

                if (userName.equals(uName) && password.equals(uPass)) {
                    Log.d("username,password", "onClick: " + uName + "  " + uPass);


                    Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_LONG).show();

                    if(callbackFragment!=null) {
                        callbackFragment.homeFragment();
                    }



                    //Intent intent = new Intent(getActivity(),HomeActivity.class);
                    //startActivity(intent);



                } else {
                    Toast.makeText(getContext(), "Incorrect username or password", Toast.LENGTH_LONG).show();

                }

                txtUername.setText("");
                txtPassword.setText("");


            }
        });





        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(callbackFragment!=null) {
                callbackFragment.registrationFragment();
            }


            }
        });*/




        return view;
    }







    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.button_login:
                userName = txtUername.getText().toString();
                password = txtPassword.getText().toString();
                String uName, uPass;
                uName = sharedPreferences.getString("userName", null);
                uPass = sharedPreferences.getString("password", null);
                Log.d("username,password", "onClick: " + uName + "  " + uPass);

                if (userName.equals(uName) && password.equals(uPass))
                {
                    Log.d("username,password", "onClick: " + uName + "  " + uPass);

                    Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();
/*

                    HomeFragment homeFragment = new HomeFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("USERNAME",userName);
                        homeFragment.setArguments(bundle);
*/

                    if(callbackFragment!=null)
                    {
                        callbackFragment.homeFragment();
                    }




//                    Intent intent = new Intent(getActivity(),HomeActivity.class);
//                    startActivity(intent);



                }
                else
                    {
                    Toast.makeText(getContext(), "Incorrect username or password", Toast.LENGTH_SHORT).show();

                }

                break;


            case R.id.textview_register:
                if(callbackFragment!=null) {
                    callbackFragment.registrationFragment();
                }
                break;

                default:
                    break;



        }

    }


    @Override
    public void onResume() {
        super.onResume();

        txtUername.setText("");
        txtPassword.setText("");
    }

    public void setCallbackFragment(CallbackFragment callbackFragment)
    {
        this.callbackFragment = callbackFragment;
    }




}
