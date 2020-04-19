package com.pixelhubllc.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentfour extends Fragment {
    private Switch mSwitch;
    SharedPref sharedPref;


    public fragmentfour() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_four, container, false);

        sharedPref = new SharedPref(getContext());
        if (sharedPref.loadNightModeState() == true) {
            getActivity().setTheme(R.style.DarkTheme);
        } else {
            getActivity().setTheme(R.style.AppTheme);
        }

        mSwitch = view.findViewById(R.id.my_switch);

        if (sharedPref.loadNightModeState() == true) {
            mSwitch.setChecked(true);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedPref.setNightModeState(true);
//                    sharedPref.setSettingFragment(true);
                    getActivity().recreate();

                } else {
                    sharedPref.setNightModeState(false);
//                    sharedPref.setSettingFragment(true);
                    getActivity().recreate();

                }
            }
        });

        return view;
    }
}
