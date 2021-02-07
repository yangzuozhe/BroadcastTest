package racom.example.broadcasttest.customnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import racom.example.broadcasttest.R;

/**
 * 自定义普通广播的 activity
 *
 * @author Administrator
 */
public class CustomNormalBroadcastActivity extends AppCompatActivity {
    NormalBroadcastReceiver mBroadcastReceiver;
    /**
     * 这是广播注册时候的 action ，同时在发送广播的时候需要用到这个字符串
     * 一般格式为：包名 + 自定义名字
     */
    public String mActionBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActionBroadcast = getPackageName() + ".MY_BROADCAST";
        findViewById(R.id.tvHello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                //如果安卓版本小于8.0就使用隐式调用，如果安卓版本大于8.0就使用显性调用
                if (Build.VERSION.SDK_INT < 26) {
                    intent = new Intent(mActionBroadcast);
                } else {
                    intent = new Intent(mActionBroadcast);
                    intent.setComponent(new ComponentName(CustomNormalBroadcastActivity.this.getPackageName(), "com.example.boardreceiver1.MyReceiver"));
                }
                sendBroadcast(intent);
            }
        });
    }

    /**
     * 动态注册
     * 当此Activity实例化时，会动态将MyBroadcastReceiver注册到系统中
     */
    @Override
    protected void onResume() {
        super.onResume();
//        //1.  实例化BroadcastReceiver子类
//        mBroadcastReceiver = new NormalBroadcastReceiver();
//        //2. 实例化 IntentFilter. 这就相当于静态注册的 <intent-filter>
//        IntentFilter intentFilter = new IntentFilter();
//        //3 . 设置接收广播的类型 这就相当于静态注册的<intent-filter> 中的 <action>
//        //这里要注意了，和系统广播不一样，这里我们自定义一个字符串
//        intentFilter.addAction(mActionBroadcast);
//        //4.动态注册：调用Context的registerReceiver（）方法
//        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    /**
     * 动态解除注册
     * 在注册广播后，我们要记得销毁广播，我们选择在 onPause 中销毁广播
     * 当此Activity销毁时，动态注册的MyBroadcastReceiver将不再接收到相应的广播。
     */
    @Override
    protected void onPause() {
        super.onPause();
//        unregisterReceiver(mBroadcastReceiver);
    }
}