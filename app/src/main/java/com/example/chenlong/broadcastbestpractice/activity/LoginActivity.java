package com.example.chenlong.broadcastbestpractice.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chenlong.broadcastbestpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_account)
    EditText mAccount;
    @BindView(R.id.et_password)
    EditText mPassword;
    @BindView(R.id.login)
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(v -> {
            String account = mAccount.getText().toString();
            String password = mPassword.getText().toString();

            if ("admin".equals(account) && "123456".equals(password)) {
                MainActivity.startMainActivity(this);
            } else {
                Toast.makeText(this, "帐号或密码错误", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
