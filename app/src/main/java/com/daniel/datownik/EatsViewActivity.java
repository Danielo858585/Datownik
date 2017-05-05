package com.daniel.datownik;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.daniel.datownik.db.Eat.Eat;
import com.daniel.datownik.db.Eat.EatsDAO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EatsViewActivity extends AppCompatActivity {

    @BindView(R.id.lv_eatsList)
    ListView eatsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eats_view);
        ButterKnife.bind(this);
        EatsDAO eatsDAO = new EatsDAO(getApplicationContext());

        eatsDAO.open();
        List<Eat> values = eatsDAO.getAllEats();
        EatListAdapter adapter = new EatListAdapter(this, R.layout.simple_eat_on_list, values);
        eatsList.setAdapter(adapter);

    }


}
