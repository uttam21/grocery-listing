package com.example.appdemo;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdemo.recyclerview.BuyMoreActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox checkBoxPizza,chechkBoxCoffee,checkBoxBurger;
    private Button buttonOrder,buttonBuyMore;

   // private TextView textView;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_home, container, false);


        String [] Countries = getResources().getStringArray(R.array.countries);

        AutoCompleteTextView actv = view.findViewById(R.id.actv);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, Countries);

        actv.setAdapter(adapter);

        addListenerOnButtonClick(view);

        radioGroup = view.findViewById(R.id.genderRadioGroup);

        //Log.d("Radio Button Id", "onCreateView: " + radioGroup.getCheckedRadioButtonId());


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = group.findViewById(checkedId);
                Log.d("Radio Button Id", "checkButton: " + group.getCheckedRadioButtonId());


            }
        });



        buttonBuyMore = view.findViewById(R.id.buttonBuyMore);
        buttonBuyMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), BuyMoreActivity.class);
                startActivity(intent);

            }
        });


        //checkButton(view);
        return view;

    }

    private void addListenerOnButtonClick(View view) {


        checkBoxPizza = (CheckBox) view.findViewById(R.id.checkBoxPizza);
        chechkBoxCoffee =(CheckBox)view.findViewById(R.id.checkBoxCoffee);
        checkBoxBurger =(CheckBox) view.findViewById(R.id.checkBoxBurger);
        buttonOrder =(Button) view.findViewById(R.id.buttonOrder);



        buttonOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");

                if(checkBoxPizza.isChecked()){
                    result.append("\nPizza 100Rs");
                    totalamount+=100;
                }
                if(chechkBoxCoffee.isChecked()){
                    result.append("\nCoffee 50Rs");
                    totalamount+=50;
                }
                if(checkBoxBurger.isChecked()){
                    result.append("\nBurger 120Rs");
                    totalamount+=120;
                }

                result.append("\nTotal: "+totalamount+"Rs");


                Toast.makeText(getContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }


}
