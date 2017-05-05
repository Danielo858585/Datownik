package com.daniel.datownik;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daniel.datownik.db.Eat.Eat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 29.04.2017.
 */

public class EatListAdapter extends ArrayAdapter<Eat> {

    public EatListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public EatListAdapter(ArrayAdapter<Eat> eat, Context context) {
        super(context, R.layout.simple_eat_on_list, (List<Eat>) eat);

    }

    public EatListAdapter(Context context, int eat, List<Eat> eats){
        super(context,eat,eats);
    }

    private ArrayList<Eat> eats;
    Context context;

    private static class ViewHolder {
        TextView typeFood;
        TextView foodAmount;
        TextView date;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.simple_eat_on_list, null);
        }
        Eat item = getItem(position);

        if (item != null) {
            TextView tv_id = (TextView) view.findViewById(R.id.lv_id);
            TextView tv_date = (TextView) view.findViewById(R.id.lv_date);
            TextView tv_amount = (TextView) view.findViewById(R.id.lv_amountFood);
            TextView tv_type = (TextView) view.findViewById(R.id.lv_typeFood);

            if (tv_id != null) {
                tv_id.setText(String.valueOf(item.getId()));
            }

            if (tv_date != null) {
                tv_date.setText(item.getDate());
            }

            if (tv_amount != null) {
                tv_amount.setText(item.getAmountOfEaten());
            }

            if (tv_type != null) {
                tv_type.setText(item.getTypeOfFood());
            }
        }

        return view;
    }
}
