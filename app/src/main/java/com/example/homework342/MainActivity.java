package com.example.homework342;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

import static com.example.homework342.Utils.*;

public class MainActivity extends AppCompatActivity {
    Spinner switch_lang;
    Spinner switch_margins;
    Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected_land = switch_lang.getSelectedItemPosition();
                Locale locale = null;
                switch (selected_land) {
                    case 0:
                        locale = new Locale("ru");
                        break;
                    case 1:
                        locale = new Locale("en");
                        break;
                }

                int selected_margin = switch_margins.getSelectedItemPosition();
                switch (selected_margin) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BIG);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                        break;
                }

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }

    private void initView() {
        switch_lang = findViewById(R.id.switch_lang);
        switch_margins = findViewById(R.id.switch_margins);
        btn_result = findViewById(R.id.btn_result);
    }
}
