package com.kolomiytsev.and_homework_121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button subscribeBtn;
    private Button clearBtn;
    private EditText nameEt;
    private EditText emailEt;
    private TextView resultTv;
    private TextView errorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.main_activity_label);

        subscribeBtn = findViewById(R.id.bt_subscribe);
        clearBtn = findViewById(R.id.bt_clear);
        nameEt = findViewById(R.id.et_name);
        emailEt = findViewById(R.id.et_email);
        resultTv = findViewById(R.id.tv_result);
        errorTv = findViewById(R.id.tv_error);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        subscribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nameEt.getText().toString().equals("") && !emailEt.getText().toString().equals("")) {
                    resultTv.setText(getString(R.string.tv_result_text, nameEt.getText(), emailEt.getText()));
                    errorTv.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
                } else {
                    errorTv.setText(R.string.tv_error_text);
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEt.setText("");
                emailEt.setText("");
                resultTv.setText("");
                errorTv.setText("");
            }
        });

    }
}
