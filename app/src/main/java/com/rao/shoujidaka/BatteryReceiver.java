package com.rao.shoujidaka;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;


/**
 * Created by Administrator on 2018/4/3.
 */

//**
//        * 监听获取手机系统剩余电量
//        * Created by Lx on 2016/9/17.
//        */
public class BatteryReceiver extends BroadcastReceiver {
    private TextView pow;

    public BatteryReceiver(TextView pow) {
        this.pow = pow;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int current = intent.getExtras().getInt("level");// 获得当前电量
        int total = intent.getExtras().getInt("scale");// 获得总电量
        int percent = current * 100 / total;
        pow.setText(percent + "%");
    }
}