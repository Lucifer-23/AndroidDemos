package com.jesse.lucifer.androidrsaplusaes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

//    private void encrypt(String content) {
//        try {
//            RSAPublicKey rsaPublicKey = RSA.loadPublicKey(getAssets().open("rsa_public_key.pem"));
//            String aesKey = AES.generateKeyString();
//            String encryptAesKey = RSA.encryptByPublicKey(aesKey, rsaPublicKey);
//            String encryptContent = AES.encrypt(content, aesKey);
//            TestData.data = encryptContent;
//            TestData.sign = encryptAesKey;
//            Log.e("Panda", "data after decrypt: " + TestData.data);
//            Log.e("Panda", "sign after decrypt: " + TestData.sign);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void decrypt() {
//        try {
//            RSAPrivateKey rsaPrivateKey = RSA.loadPrivateKey(getAssets().open("rsa_private_key.pem"));
//            //解密AES-KEY
//            String decryptAesKey = RSA.decryptByPrivateKey(TestData.sign, rsaPrivateKey);
//            //AES解密数据
//            String decrypt = AES.decrypt(TestData.data, decryptAesKey);
//            Log.e("Panda", "data after encrypt: " + decrypt);
//            Log.e("Panda", "sign after encrypt: " + decryptAesKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static class TestData {
//        public static String data;
//        public static String sign;
//    }
}
