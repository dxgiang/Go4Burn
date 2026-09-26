package com.example.go4burn;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewInfomationActivity extends AppCompatActivity {
    private Button continueBtn;
    private ImageView buttonMale;
    private ImageView buttonFemale;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_infomation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()
            );
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });
        TextView textView = findViewById(R.id.tvBrand);
        textView.setText(Html.fromHtml(getString(R.string.name_app), Html.FROM_HTML_MODE_LEGACY));
        continueBtn = findViewById(R.id.btnTiepTuc);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewInfomationActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0f);
        ColorMatrixColorFilter grayFilter = new ColorMatrixColorFilter(matrix);

        buttonMale = findViewById(R.id.imgMale);
        buttonMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMale.clearColorFilter();
                buttonFemale.setColorFilter(grayFilter);
            }
        });
        buttonFemale = findViewById(R.id.imgFemale);
        buttonFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFemale.clearColorFilter();
                buttonMale.setColorFilter(grayFilter);
            }
        });
    }

    public Button getContinueBtn() {
        return continueBtn;
    }

    public void setContinueBtn(Button continueBtn) {
        this.continueBtn = continueBtn;
    }
}
