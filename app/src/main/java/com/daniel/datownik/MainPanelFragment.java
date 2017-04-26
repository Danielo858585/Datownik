package com.daniel.datownik;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainPanelFragment extends Fragment {

    private MainPanelFragmentListener listener;


    public MainPanelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_panel, container, false);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.dateOfBirth:
                        updateDetail("Szczegółowe informacje o elemencie pierwszym.");
                        goToCheckAgeActivity();
                        break;
                    case R.id.walk:
                        updateDetail("Szczegółowe informacje o elemencie drugim.");
                        break;
                    case R.id.eat:
                        updateDetail("Szczegółowe informacje o elemencie drugim.");
                        goToEatActivity();
                        break;
                    case R.id.toilet:
                        updateDetail("Szczegółowe informacje o elemencie drugim.");
                        break;
                    case R.id.addCHild:
                        updateDetail("Szczegółowe informacje o elemencie drugim.");
                        goToAddChildActivity();
                        break;
                    default:
                        break;
                }
            }
        };
        ImageButton dob = (ImageButton) view.findViewById(R.id.dateOfBirth);
        ImageButton wlk = (ImageButton) view.findViewById(R.id.walk);
        ImageButton et = (ImageButton) view.findViewById(R.id.eat);
        ImageButton tot = (ImageButton) view.findViewById(R.id.toilet);
        ImageButton ach = (ImageButton) view.findViewById(R.id.addCHild);

        dob.setOnClickListener(onClickListener);
        wlk.setOnClickListener(onClickListener);
        et.setOnClickListener(onClickListener);
        tot.setOnClickListener(onClickListener);
        ach.setOnClickListener(onClickListener);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof MainPanelFragmentListener) {
            listener = (MainPanelFragmentListener) activity;
        } else {
            throw new ClassCastException(activity.toString() + " musi implementować interfejs: OverviewFragment.MainPanelFragmentListener");
        }
    }

    public interface MainPanelFragmentListener {
        public void onItemSelected(String msg);
    }

    public void updateDetail(String msg) {
        listener.onItemSelected(msg);
    }

    public void goToAddChildActivity(){
        Intent intent = new Intent(getContext(),AddChildrenActivity.class);
        startActivity(intent);
    }

    public void goToCheckAgeActivity(){
        Intent intent = new Intent(getContext(),CheckAgeActivity.class);
        startActivity(intent);
    }

    public void goToEatActivity(){
        Intent intent = new Intent(getContext(),AddEatActivity.class);
        startActivity(intent);
    }
}
