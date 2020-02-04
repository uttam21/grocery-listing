package com.example.appdemo;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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
public class RegistrationFragment extends Fragment {


    private EditText txtUername, txtPassword,txtConfirmPassword;
    private Button btnRegister;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String userName, password, confirmPassword;

    @Override
    public void onAttach(@NonNull Context context) {
         sharedPreferences = context.getSharedPreferences("usersFile", Context.MODE_PRIVATE);
         editor = sharedPreferences.edit();



        super.onAttach(context);
    }


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        txtUername = view.findViewById(R.id.edittext_username);
        txtPassword = view.findViewById(R.id.edittext_password);
        txtConfirmPassword = view.findViewById(R.id.edittext_confirm_password);
        btnRegister = view.findViewById(R.id.button_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = txtUername.getText().toString();
                password =  txtPassword.getText().toString();
                confirmPassword = txtConfirmPassword.getText().toString();

                editor.putString("userName",userName);
                editor.putString("password",password);

                if(userName.equals("") ||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getContext(),"All fields mandatory..!!",Toast.LENGTH_SHORT).show();

                }

                else if(password.equals(confirmPassword))
                {

                    editor.apply();
                    Toast.makeText(getContext(),"Registered Successfully.!!",Toast.LENGTH_LONG).show();

                    txtUername.setText("");
                    txtPassword.setText("");
                    txtConfirmPassword.setText("");


                }

                else
                {

                    Toast.makeText(getContext(),"Not matching password",Toast.LENGTH_SHORT).show();

                }



            }
        });



        return view;
    }

}
