package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CallbackFragment{
    private Toolbar toolbar;
    Fragment fragment;
    FragmentManager fragmentManager;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        addFragment();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_menu,menu);

        return true;
    }

    public void addFragment()
    {
        LoginFragment fragment = new LoginFragment();
        fragment.setCallbackFragment(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit();

    }

    /*public void registrationFragment()
    {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container,new RegistrationFragment()).addToBackStack(null).commit();

    }





    @Override
    public void changeFragment() {
        //registrationFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container,new RegistrationFragment()).addToBackStack(null).commit();

    }*/

    @Override
    public void registrationFragment() {

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container,new RegistrationFragment()).addToBackStack(null).commit();

    }


    @Override
    public void homeFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container,new HomeFragment()).addToBackStack(null).commit();


    }







    public void checkButton(View view) {
        Toast.makeText(this,((RadioButton)view).getText() + " Selected", Toast.LENGTH_SHORT).show();




    }






}
