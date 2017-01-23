package com.example.chenlong.broadcastbestpractice.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.chenlong.broadcastbestpractice.util.ActivityCollector;

/**
 * Created by ChenLong on 2017/1/21.
 */

public class BaseActivity extends AppCompatActivity {


    private OfflineReceiver mOfflineReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActicity(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mOfflineReceiver = new OfflineReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("offline");
        registerReceiver(mOfflineReceiver, filter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if (mOfflineReceiver != null) {
            unregisterReceiver(mOfflineReceiver);
            mOfflineReceiver = null;        //优化  释放资源
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class OfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle("警告");
            dialog.setMessage("您的帐号正在别处登录,即将关闭!请重新登录");
            dialog.setCancelable(false);

            dialog.setPositiveButton("确定", (dialog1, which) -> {
                ActivityCollector.finishAll();
                Intent intent1=new Intent(context,LoginActivity.class);
                startActivity(intent1);
            });

            dialog.show();
        }
    }
}
