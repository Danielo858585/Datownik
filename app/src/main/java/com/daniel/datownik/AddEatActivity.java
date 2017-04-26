package com.daniel.datownik;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddEatActivity extends AppCompatActivity {
    private static final String TAG = "AddEatActivity";
    private Intent intent;
    @BindView(R.id.eatBtnAddEat)
    Button addEat;
    @BindView(R.id.eatEtTypeEat)
    EditText typeEat;
    @BindView(R.id.eatEtAmountFood)
    EditText amountFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eat);
        ButterKnife.bind(this);
        addEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEatButtonClick();
            }
        });

    }

    public void addEatButtonClick(){
        String amountEat = amountFood.getText().toString();
        String typeFood = typeEat.getText().toString();
        if(amountEat.length() <  1 || typeFood.length() <  1){
           AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Niepoprawne dane")
                   .setMessage("Wprowadz ilość i typ posiłku")
                   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {

                       }
                   });
        AlertDialog alertDialog = builder.show();
        }
    }
}
