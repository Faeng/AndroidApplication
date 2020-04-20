package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityItemPage46 extends AppCompatActivity {

    private CheckBox never, rarely, always, hardly, often;
    private  int level;
    private ArrayList<Integer> answer;
    private CallPythonScript callPythonScript;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        callPythonScript = new CallPythonScript();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item46_page);
        never = findViewById(R.id.item46_checkBox_level0);
        rarely = findViewById(R.id.item46_checkBox_level2);
        always = findViewById(R.id.item46_checkBox_level4);
        hardly = findViewById(R.id.item46_checkBox_level1);
        often = findViewById(R.id.item46_checkBox_level3);
        Button predict = findViewById(R.id.item46_button_predict);
        answer = (ArrayList<Integer>) getIntent().getSerializableExtra("ans");
        callPythonScript.call(answer.toString());
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (never.isChecked() || rarely.isChecked() || always.isChecked() || hardly.isChecked() || often.isChecked()) {
                    answer.add(level);
                    Toast toast = Toast.makeText(getApplicationContext(),callPythonScript.getAnswer(),Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


    }

    public void onCheckboxClicked(View view) {
        switch(view.getId()) {
            case R.id.item46_checkBox_level0:
                rarely.setChecked(false);
                always.setChecked(false);
                hardly.setChecked(false);
                often.setChecked(false);
                level = 0;
                break;
            case R.id.item46_checkBox_level2:
                never.setChecked(false);
                always.setChecked(false);
                hardly.setChecked(false);
                often.setChecked(false);
                level = 2;
                break;
            case R.id.item46_checkBox_level4:
                rarely.setChecked(false);
                never.setChecked(false);
                hardly.setChecked(false);
                often.setChecked(false);
                level = 4;
                break;
            case R.id.item46_checkBox_level1:
                rarely.setChecked(false);
                always.setChecked(false);
                never.setChecked(false);
                often.setChecked(false);
                level = 1;
                break;
            case R.id.item46_checkBox_level3:
                rarely.setChecked(false);
                always.setChecked(false);
                hardly.setChecked(false);
                never.setChecked(false);
                level = 3;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}
