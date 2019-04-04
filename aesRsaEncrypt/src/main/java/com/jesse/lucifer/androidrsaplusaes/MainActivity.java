package com.jesse.lucifer.androidrsaplusaes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.jesse.lucifer.androidrsaplusaes.encrypt.EncryptUtil;
import com.jesse.lucifer.androidrsaplusaes.encryptPlanB.AES;
import com.jesse.lucifer.androidrsaplusaes.encryptPlanB.RSA;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mInput;
    EditText mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInput = findViewById(R.id.input);
        mResult = findViewById(R.id.result);
        findViewById(R.id.encrypt).setOnClickListener(this);
        findViewById(R.id.decrypt).setOnClickListener(this);
        findViewById(R.id.clearInput).setOnClickListener(this);
        findViewById(R.id.clearResult).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = "";
        String result = "";
        switch (v.getId()) {
            case R.id.encrypt:
                input = mInput.getText().toString();
                result = EncryptUtil.encryptAes(input);
                mResult.setText(result);
                break;
            case R.id.decrypt:
                input = mInput.getText().toString();
                result = EncryptUtil.decryptAes(input);
                mResult.setText(result);
                break;
            case R.id.clearInput:
                mInput.setText("");
                break;
            case R.id.clearResult:
                mResult.setText("");
                break;
        }
        Log.e("Panda", "input: " + input);
        Log.e("Panda", "result: " + result);
    }
}
