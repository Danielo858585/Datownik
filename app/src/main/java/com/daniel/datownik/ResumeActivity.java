package com.daniel.datownik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResumeActivity extends AppCompatActivity {

    private String name;
    private long days,weeks;
    //private TextView dni;
    @BindView(R.id.tv_liczbaDni) TextView titleDay;
    @BindView(R.id.tv_liczbaTygodni) TextView titleWeeks;
    @BindView(R.id.tv_liczbaDniCyfra) TextView dni;
    @BindView(R.id.tv_liczbaTygodniCyfra) TextView tygodnie;
    @BindView(R.id.tv_title) TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        days = bundle.getLong("dni");
        weeks = bundle.getLong("tygodnie");
        dni.setText(String.valueOf(days));
        tygodnie.setText(String.valueOf(weeks));
        if(name.length()!=0){
            title.setText(name);
            titleDay.setText(name + "ma dni");
            titleWeeks.setText(name+ "ma tygodni");
        }

    }
}
