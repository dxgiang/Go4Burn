package com.example.go4burn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        // Cau hinh webview
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);        // bat buoc bat de chay file js
        webSettings.setDomStorageEnabled(true);        // Cho phep luu LocalStorage neu can
        webSettings.setAllowFileAccess(true);          // Cho phep doc file noi bo

        // Dam bao mo trang ngay trong app khong bi nhay ra trinh duyet Chrome
        webView.setWebViewClient(new WebViewClient());

        // Tai trang index html tu thu muc assets
        webView.loadUrl("file:///android_asset/index.html");

        // Xu ly nut Back cua Android: Quay lai trang web truoc thay vi thoat app ngay
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }
}