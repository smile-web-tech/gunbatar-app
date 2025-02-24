package com.gunbatarshapagy.west_project.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gunbatarshapagy.west_project.R;

public class info_activity extends AppCompatActivity {

    private Toolbar infoToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        infoToolbar = findViewById(R.id.info_toolbar);
        setSupportActionBar(infoToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            changeNavigationIconColor(Color.WHITE);
        }

        infoToolbar.setTitle(R.string.infoAppbar);
        infoToolbar.setTitleTextColor(Color.WHITE);

    }

    private void changeNavigationIconColor(int color) {
        Drawable navigationIcon = infoToolbar.getNavigationIcon();
        if (navigationIcon != null){
            navigationIcon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
