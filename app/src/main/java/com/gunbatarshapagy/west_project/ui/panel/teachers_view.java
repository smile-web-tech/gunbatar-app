package com.gunbatarshapagy.west_project.ui.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.gunbatarshapagy.west_project.R;

public class teachers_view extends AppCompatActivity {

    private WebView panelView;
    private ProgressBar progressBar;
    private TextView noInternetText;
    private Button tryAgainButton;
    private Toolbar toolbar;
    private final String panelUrl = "https://www.gunbatarshapagy.com/teachers/teachers-mobile.html";

    @SuppressLint({"SetJavaScriptEnabled", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_view);

        panelView = findViewById(R.id.adminPanel);
        progressBar = findViewById(R.id.progressBar);
        noInternetText = findViewById(R.id.noInternetText);
        tryAgainButton = findViewById(R.id.TryAgainButton);
        toolbar = findViewById(R.id.my_toolbar);

        // Set the Toolbar as the ActionBar
        setSupportActionBar(toolbar);
        WebSettings settings = panelView.getSettings();
        settings.setDomStorageEnabled(true);
        // Enable the Up button (back button)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            // Change the navigation icon color

            changeNavigationIconColor(Color.WHITE);
        }

        panelView.getSettings().setJavaScriptEnabled(true);

        // Set the title and color
        toolbar.setTitle(R.string.teachers_tm);
        toolbar.setTitleTextColor(Color.WHITE);

  // Change the font of the toolbar title

   if (isNetworkAvailable()){
       loadWebView();
   } else {
       showNoInternet();
   }

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadWebView();
            }
        });
    }

    private void changeNavigationIconColor(int color) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }



    private void loadWebView() {
        noInternetText.setVisibility(View.GONE);
        tryAgainButton.setVisibility(View.GONE);
        panelView.setVisibility(View.VISIBLE);

        panelView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

         @Override
         public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
             showNoInternet();
         }
        });

        panelView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);

                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                }
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        panelView.loadUrl(panelUrl);
    }

    private void showNoInternet() {
        panelView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        tryAgainButton.setVisibility(View.VISIBLE);
        noInternetText.setVisibility(View.VISIBLE);

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && panelView.canGoBack()) {
            panelView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}