package com.daniel.datownik;

import android.app.Activity;
import android.database.SQLException;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.datownik.db.ChildrensDAO;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddChildrenActivity extends Activity {

    private static final String TAG = "AddChildrenActivity";
    @Nullable
    @BindView(R.id.et_childName)
    EditText childName;
    @BindView(R.id.et_day)
    EditText day;
    @BindView(R.id.et_month)
    EditText month;
    @BindView(R.id.et_year)
    EditText year;
    @BindView(R.id.btn_saveChild)
    Button save;
    @BindView(R.id.btn_back)
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_children);
        ButterKnife.bind(this);

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
                    if (Integer.parseInt(day.getText().toString()) < 1 || Integer.parseInt(day.getText().toString()) > 31) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Dzień nie może być poza zakresem 1 - 31", Toast.LENGTH_SHORT);
                        toast.show();
                        day.setText("");
                    } else {
                        if (s.length() >= 2) {
                            month.requestFocus();
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
                    if (Integer.parseInt(month.getText().toString()) < 1 || Integer.parseInt(month.getText().toString()) > 12) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Miesiąc nie może być poza zakresem 1 - 12", Toast.LENGTH_SHORT);
                        toast.show();
                        month.setText("");
                    } else {
                        if (s.length() >= 2) {
                            year.requestFocus();
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
                    if (Integer.parseInt(year.getText().toString()) < 1900 || Integer.parseInt(year.getText().toString()) > Calendar.getInstance().get(Calendar.YEAR)) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Rok musi zawierać się w zakresie 1900 - 2017", Toast.LENGTH_SHORT);
                        toast.show();
                        year.setText("");
                    } else {
                        if (s.length() >= 4) {
                            childName.requestFocus();
                        }
                    }
                }
            }
        };


        day.addTextChangedListener(watcherDay);
        month.addTextChangedListener(watcherMonth);
        year.addTextChangedListener(watcherYear);
    }

    @OnClick(R.id.btn_saveChild)
    public void saveChild(){
        String childNameString = childName.getText().toString();
        String dayString = day.getText().toString();
        String monthString = month.getText().toString();
        String yearString = year.getText().toString();

        ChildrensDAO childrensDAO = new ChildrensDAO(this);

        if (!editTextIsEmpty(day) &&
                !editTextIsEmpty(month) &&
                !editTextIsEmpty(year) &&
                !editTextIsEmpty(childName)) {
            try {
                childrensDAO.insertChild(childNameString, day.getText().toString(), month.getText().toString(), year.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(), "Zapisane", Toast.LENGTH_SHORT);
                toast.show();
            } catch (SQLException e) {
                Log.e(TAG, "Błąd przy dodawaniu dziecka " + e.toString());

            }

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
