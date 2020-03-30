package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ActivityItemPage43 extends AppCompatActivity {

    private CheckBox never, rarely, always, hardly, often;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item43_page);
        Button button = findViewById(R.id.item43_button_next);
        never = findViewById(R.id.item43_checkBox_level0);
        rarely = findViewById(R.id.item43_checkBox_level2);
        always = findViewById(R.id.item43_checkBox_level4);
        hardly = findViewById(R.id.item43_checkBox_level1);
        often = findViewById(R.id.item43_checkBox_level3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityItemPage43.this, ActivityItemPage44.class));
            }
        });
    }

    public void onCheckboxClicked(View view) {
        switch(view.getId()) {
            case R.id.item43_checkBox_level0:
                rarely.setChecked(false);
                always.setChecked(false);
                hardly.setChecked(false);
                often.setChecked(false);
                break;
            case R.id.item43_checkBox_level2:
                never.setChecked(false);
                always.setChecked(false);
                hardly.setChecked(false);
                often.setChecked(false);
                break;
            case R.id.item43_checkBox_level4:
                rarely.setChecked(false);
                never.setChecked(false);
                hardly.setChecked(false);
                often.setChecked(false);
                break;
            case R.id.item43_checkBox_level1:
                rarely.setChecked(false);
                always.setChecked(false);
                never.setChecked(false);
                often.setChecked(false);
                break;
            case R.id.item43_checkBox_level3:
                rarely.setChecked(false);
                always.setChecked(false);
                hardly.setChecked(false);
                never.setChecked(false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}
