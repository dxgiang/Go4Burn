package com.example.go4burn;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnalystActivity extends AppCompatActivity {
    private LinearLayout buttonHome;
    private LinearLayout buttonProfile;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyst);
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
                Intent intent = new Intent(AnalystActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        buttonProfile = findViewById(R.id.tabProfile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalystActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }

    public LinearLayout getButtonHome() {
        return buttonHome;
    }

    public void setButtonHome(LinearLayout buttonHome) {
        this.buttonHome = buttonHome;
    }

    public LinearLayout getButtonProfile() {
        return buttonProfile;
    }

    public void setButtonProfile(LinearLayout buttonProfile) {
        this.buttonProfile = buttonProfile;
    }
}