package com.daniel.datownik;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button check, save, open, clear;
    private EditText et_day, et_month, et_year, et_childName;
    private int day, month, year;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = (Button) findViewById(R.id.btn_check);
        save = (Button) findViewById(R.id.btn_save);
        open = (Button) findViewById(R.id.btn_open);
        clear = (Button) findViewById(R.id.btn_clear);
        et_day = (EditText) findViewById(R.id.et_day);
        et_month = (EditText) findViewById(R.id.et_month);
        et_year = (EditText) findViewById(R.id.et_year);
        et_childName = (EditText) findViewById(R.id.et_childName);
        intent = new Intent(this, ResumeActivity.class);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearOnClick();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveOnClick();
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOnClick();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Calendar calendar = Calendar.getInstance();
                Calendar dateOfBirth = Calendar.getInstance();
                Calendar result = Calendar.getInstance();


                try{
                    day = Integer.parseInt(et_day.getText().toString());
                    month = Integer.parseInt(et_month.getText().toString()) - 1;
                    year = Integer.parseInt(et_year.getText().toString());
                    dateOfBirth.set(year, month, day);
                }
                catch (Exception e){

                }

                long roznica = calendar.getTimeInMillis() - dateOfBirth.getTimeInMillis();
                long liczbaMlsWDobie = 1000 * 60 * 60 * 24;
                result.setTimeInMillis(roznica);
                long wynikDni = (result.getTimeInMillis() / liczbaMlsWDobie);
                long wynikTygodnie = wynikDni / 7;

                intent.putExtra("tygodnie", wynikTygodnie);
                intent.putExtra("dni", wynikDni);
                if (et_childName.getText().toString().length()>0){
                    intent.putExtra("name",et_childName.getText().toString());
                }
                else{
                    intent.putExtra("name","");
                }
                startActivity(intent);
            }
        });

        TextWatcher watcherDay = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    if (Integer.parseInt(et_day.getText().toString()) < 1 || Integer.parseInt(et_day.getText().toString()) > 31) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Dzień nie może być poza zakresem 1 - 31", Toast.LENGTH_SHORT);
                        toast.show();
                        et_day.setText("");
                    } else {
                        if (s.length() >= 2) {
                            et_month.requestFocus();
                        }
                    }
                }
            }
        };
        TextWatcher watcherMonth = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    if (Integer.parseInt(et_month.getText().toString()) < 1 || Integer.parseInt(et_month.getText().toString()) > 12) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Miesiąc nie może być poza zakresem 1 - 12", Toast.LENGTH_SHORT);
                        toast.show();
                        et_month.setText("");
                    } else {
                        if (s.length() >= 2) {
                            et_year.requestFocus();
                        }
                    }
                }
            }
        };
        TextWatcher watcherYear = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 4) {
                    if (Integer.parseInt(et_year.getText().toString()) < 1900 || Integer.parseInt(et_year.getText().toString()) > Calendar.getInstance().get(Calendar.YEAR)) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Rok musi zawierać się w zakresie 1900 - 2017", Toast.LENGTH_SHORT);
                        toast.show();
                        et_year.setText("");
                    } else {
                        if (s.length() >= 4) {
                            et_childName.requestFocus();
                        }
                    }
                }
            }
        };


        et_day.addTextChangedListener(watcherDay);
        et_month.addTextChangedListener(watcherMonth);
        et_year.addTextChangedListener(watcherYear);

    }

    private void clearOnClick() {
        et_day.setText("");
        et_month.setText("");
        et_year.setText("");
        et_childName.setText("");
    }

    private void openOnClick() {
        SharedPreferences sharedPreferences = getSharedPreferences("datownikMojeUstawienia", MODE_PRIVATE);
        if (sharedPreferences.contains(et_childName.getText().toString() + "childName")) {
            if ((sharedPreferences.getString(et_childName.getText().toString() + "childName", "")).equals(et_childName.getText().toString())) {
                et_day.setText(Integer.toString(sharedPreferences.getInt(et_childName.getText().toString() + "dayOfBirth", 0)));
                et_month.setText(Integer.toString(sharedPreferences.getInt(et_childName.getText().toString() + "monthOfBirth", 0)));
                et_year.setText(Integer.toString(sharedPreferences.getInt(et_childName.getText().toString() + "yearOfBirth", 0)));
                et_childName.setText(sharedPreferences.getString(et_childName.getText().toString() + "childName", "Dawid"));
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Brak dziecka o imieniu " + et_childName.getText().toString(), Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    }

    private void saveOnClick() {
        SharedPreferences sharedPreferences = getSharedPreferences("datownikMojeUstawienia", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!editTextIsEmpty(et_day) &&
                !editTextIsEmpty(et_month) &&
                !editTextIsEmpty(et_year) &&
                !editTextIsEmpty(et_childName)) {
            editor.putInt(et_childName.getText().toString() + "dayOfBirth", Integer.parseInt(et_day.getText().toString()));
            editor.putInt(et_childName.getText().toString() + "monthOfBirth", Integer.parseInt(et_month.getText().toString()));
            editor.putInt(et_childName.getText().toString() + "yearOfBirth", Integer.parseInt(et_year.getText().toString()));
            editor.putString(et_childName.getText().toString() + "childName", et_childName.getText().toString());
            editor.apply();
            Toast toast = Toast.makeText(getApplicationContext(), "Zapisane", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Uzupelnij dane", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    public boolean editTextIsEmpty(EditText editText) {
        if (editText.getText().equals("")) {
            return true;
        } else
            return false;
    }
}
