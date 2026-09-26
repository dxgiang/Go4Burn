package com.example.go4burn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.go4burn.services.CacheManager;

public class SettingActivity extends AppCompatActivity {
    private ImageView buttonBack;
    private TextView cacheText;
    private Button buttonExit;
    private CacheManager cacheMng;
    private TextView clearCache;
    private TextView chooseM;
    private TextView chooseCm;
    private TextView chooseKg;
    private TextView chooseLb;
    public TextView getCacheText() {
        return cacheText;
    }

    public void setCacheText(TextView cacheText) {
        this.cacheText = cacheText;
    }

    public CacheManager getCacheMng() {
        return cacheMng;
    }

    public void setCacheMng(CacheManager cacheMng) {
        this.cacheMng = cacheMng;
    }

    public TextView getClearCache() {
        return clearCache;
    }

    public void setClearCache(TextView clearCache) {
        this.clearCache = clearCache;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        buttonBack = findViewById(R.id.btnBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        buttonExit = findViewById(R.id.btnExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        cacheText = findViewById(R.id.tvCacheSize);
        cacheMng = new CacheManager();
        String cache = cacheMng.getTotalCacheSize(SettingActivity.this);
        cacheText.setText(cache);
        clearCache = findViewById(R.id.btnClearCache);
        clearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cacheMng.clearAllCache(SettingActivity.this);
                cacheText.setText("0 Bytes");
            }
        });
        chooseM = findViewById(R.id.tvUnitMeter);
        chooseM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseM.setTextColor(Color.parseColor("#111111"));
                chooseCm.setTextColor(Color.parseColor("#8E8E93"));
            }
        });
        chooseCm = findViewById(R.id.tvUnitCm);
        chooseCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseCm.setTextColor(Color.parseColor("#111111"));
                chooseM.setTextColor(Color.parseColor("#8E8E93"));
            }
        });
        chooseKg = findViewById(R.id.tvUnitKg);
        chooseKg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseKg.setTextColor(Color.parseColor("#111111"));
                chooseLb.setTextColor(Color.parseColor("#8E8E93"));
            }
        });
        chooseLb = findViewById(R.id.tvUnitLb);
        chooseLb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseLb.setTextColor(Color.parseColor("#111111"));
                chooseKg.setTextColor(Color.parseColor("#8E8E93"));
            }
        });
    }

    public ImageView getButtonBack() {
        return buttonBack;
    }

    public void setButtonBack(ImageView buttonBack) {
        this.buttonBack = buttonBack;
    }

    public Button getButtonExit() {
        return buttonExit;
    }

    public void setButtonExit(Button buttonExit) {
        this.buttonExit = buttonExit;
    }
}