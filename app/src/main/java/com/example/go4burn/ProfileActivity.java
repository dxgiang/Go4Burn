package com.example.go4burn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {
    private LinearLayout buttonHome;
    private LinearLayout buttonAnalyst;
    private ImageView buttonSetting;
    private TextView chooseMale;
    private TextView chooseFemale;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()
            );
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });
        TextView textView = findViewById(R.id.tvBrand);
        textView.setText(Html.fromHtml(getString(R.string.name_app), Html.FROM_HTML_MODE_LEGACY));
        buttonHome = findViewById(R.id.tabHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        buttonAnalyst = findViewById(R.id.tabAnalytics);
        buttonAnalyst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AnalystActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        buttonSetting = findViewById(R.id.btnSettings);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SettingActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        chooseMale = findViewById(R.id.tvGenderMale);
        chooseMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseMale.setTextColor(Color.parseColor("#111111"));
                chooseFemale.setTextColor(Color.parseColor("#8E8E93"));
            }
        });
        chooseFemale = findViewById(R.id.tvGenderFemale);
        chooseFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFemale.setTextColor(Color.parseColor("#111111"));
                chooseMale.setTextColor(Color.parseColor("#8E8E93"));
            }
        });
    }

    public LinearLayout getButtonHome() {
        return buttonHome;
    }

    public void setButtonHome(LinearLayout buttonHome) {
        this.buttonHome = buttonHome;
    }

    public LinearLayout getButtonAnalyst() {
        return buttonAnalyst;
    }

    public void setButtonAnalyst(LinearLayout buttonAnalyst) {
        this.buttonAnalyst = buttonAnalyst;
    }

    public ImageView getButtonSetting() {
        return buttonSetting;
    }

    public void setButtonSetting(ImageView buttonSetting) {
        this.buttonSetting = buttonSetting;
    }
}