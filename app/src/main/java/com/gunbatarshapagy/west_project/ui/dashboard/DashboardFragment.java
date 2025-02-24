package com.gunbatarshapagy.west_project.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.gunbatarshapagy.west_project.databinding.FragmentDashboardBinding;
import com.gunbatarshapagy.west_project.ui.info_activity;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    CardView infoBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        infoBtn = binding.infoBtn;
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), info_activity.class);
                startActivity(intent);
            }
        });

        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}