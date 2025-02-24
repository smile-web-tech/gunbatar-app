package com.gunbatarshapagy.west_project.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.gunbatarshapagy.west_project.databinding.FragmentHomeBinding;

import com.gunbatarshapagy.west_project.ui.panel.gallery1_view;
import com.gunbatarshapagy.west_project.ui.panel.panel_view;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    LinearLayout row1;
    CardView chareler_cardview,register_cardview,advantage_cardview,question_cardview,news_cardview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        row1 = binding.row1; // Use binding to find the view
        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentNavigate();
            }
        });


        chareler_cardview = binding.charelerCardview;
        chareler_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ýakyn wagtda..", Toast.LENGTH_SHORT).show();
            }
        });

        advantage_cardview = binding.advantagesCardview;
        advantage_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ýakyn wagtda..", Toast.LENGTH_SHORT).show();
            }
        });

        question_cardview = binding.questionCardview;
        question_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ýakyn wagtda..", Toast.LENGTH_SHORT).show();
            }
        });
        register_cardview = binding.registerCardview;
        register_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ýakyn wagtda..", Toast.LENGTH_SHORT).show();
            }
        });

        news_cardview = binding.newsCardview;
        news_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ýakyn wagtda..", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void fragmentNavigate() {
        Intent intent = new Intent(getContext(), panel_view.class);
        startActivity(intent);
    }
    private void fragmentNavigate2(){
        Intent intent2 = new Intent(getContext(), gallery1_view.class);
        startActivity(intent2);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}