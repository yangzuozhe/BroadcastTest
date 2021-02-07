package racom.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

import androidx.appcompat.app.AppCompatActivity;

import racom.example.broadcasttest.customnormal.NormalBroadcastReceiver;

/**
 * 类描述
 *
 * @author HB.yangzuozhe
 * @date 2021-02-07
 */
public class BroadcastUtils {
    private NormalBroadcastReceiver mBroadcastReceiver;

    public <T extends BroadcastReceiver> void registerReceiver(T broadcastReceiver, AppCompatActivity activity, String action) {
//        //1.  实例化BroadcastReceiver子类
        mBroadcastReceiver = (NormalBroadcastReceiver) broadcastReceiver;
//        mBroadcastReceiver = new MyBroadcastReceiver();
        //2. 实例化 IntentFilter. 这就相当于静态注册的 <intent-filter>
        IntentFilter intentFilter = new IntentFilter();
        //3 . 设置接收广播的类型 这就相当于静态注册的<intent-filter> 中的 <action>
        intentFilter.addAction(action);
        //4.动态注册：调用Context的registerReceiver（）方法
        activity.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void unregisterReceiver(AppCompatActivity activity){
        activity.unregisterReceiver(mBroadcastReceiver);
    }
}
