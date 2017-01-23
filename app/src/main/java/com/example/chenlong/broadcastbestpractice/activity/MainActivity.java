package com.example.chenlong.broadcastbestpractice.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.chenlong.broadcastbestpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.button_outline)
    Button mOutline;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mOutline.setOnClickListener(v -> {
            Intent intent = new Intent("offline");
            sendBroadcast(intent);
        });
    }

    public static void startMainActivity(Context context)
    {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
