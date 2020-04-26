package com.pixelhubllc.viewpager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentfour extends Fragment {
    private Switch mSwitch;
    private SharedPref sharedPref;
    private Button alertDialogBtn;

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
        alertDialogBtn = view.findViewById(R.id.alert_btn);

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

        alertDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_layout, null);

                TextView canceTv, clearTv;
                canceTv = view.findViewById(R.id.cancel_tv);
                clearTv = view.findViewById(R.id.clear_tv);

                canceTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    Toast.makeText(getActivity(), "Cancel Clicked!", Toast.LENGTH_SHORT).show();
                    builder.dismiss();
                    }
                }
                );

                clearTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Clear clicked!", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                });

                builder.setView(view);
                builder.show();

            }
        });
        return view;
    }
}
