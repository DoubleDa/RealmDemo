package com.dyx.rdp.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * project name：RealmDemoProject
 * class describe：
 * create person：dayongxin
 * create time：16/9/11 下午5:38
 * alter person：dayongxin
 * alter time：16/9/11 下午5:38
 * alter remark：
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
