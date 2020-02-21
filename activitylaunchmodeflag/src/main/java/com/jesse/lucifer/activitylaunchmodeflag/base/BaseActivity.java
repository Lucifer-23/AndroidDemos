package com.jesse.lucifer.activitylaunchmodeflag.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jesse.lucifer.activitylaunchmodeflag.R;
import com.jesse.lucifer.activitylaunchmodeflag.SingleInstanceLaunchModeActivityA;
import com.jesse.lucifer.activitylaunchmodeflag.SingleTaskLaunchModeActivityA;
import com.jesse.lucifer.activitylaunchmodeflag.SingleTopLaunchModeActivityA;
import com.jesse.lucifer.activitylaunchmodeflag.StandardLaunchModeActivityA;
import com.jesse.lucifer.activitylaunchmodeflag.StandardLaunchModeActivityC;
import com.jesse.lucifer.activitylaunchmodeflag.StandardLaunchModeCustomAffinityActivityB;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    @BindView(R.id.id_base_activity_name)
    TextView mActivityName;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mUnbinder = ButterKnife.bind(this);

        mActivityName.setText(getLocalClassName());
        Log.e(TAG, "onCreate");
    }

    @OnClick({R.id.id_base_1,
            R.id.id_base_2,
            R.id.id_base_3,
            R.id.id_base_4,
            R.id.id_base_5,
            R.id.id_base_10})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_base_1:
                startActivity(this, StandardLaunchModeActivityA.class);
                break;
            case R.id.id_base_2:
                startActivity(this, StandardLaunchModeCustomAffinityActivityB.class);
                break;
            case R.id.id_base_3:
                startActivity(this, StandardLaunchModeActivityC.class);
                break;
            case R.id.id_base_4:
                startActivity(this, SingleTopLaunchModeActivityA.class);
                break;
            case R.id.id_base_5:
                startActivity(this, SingleInstanceLaunchModeActivityA.class);
                break;
            case R.id.id_base_10:
//                startActivity(this, SingleTaskLaunchModeActivityA.class);
                Intent intent = new Intent(this, SingleTaskLaunchModeActivityA.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "onNewIntent");
    }

    public static void startActivity(Activity activity, Class destination) {
        Intent intent = new Intent(activity, destination);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }
}