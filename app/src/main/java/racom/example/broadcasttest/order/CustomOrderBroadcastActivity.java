package racom.example.broadcasttest.order;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import racom.example.broadcasttest.R;
import racom.example.broadcasttest.customnormal.NormalBroadcastReceiver;

/**
 * 自定义有序广播的活动
 *
 * @author HB.yangzuozhe
 * @date 2021-02-07
 */
public class CustomOrderBroadcastActivity extends AppCompatActivity {
    private String mActionText;
    private OrderBroadcastReceiver mOrderBroadcastReceiver;
    private NormalBroadcastReceiver mNormalBroadcastReceiver;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActionText = getPackageName() + ".OREDR";
        mTextView = findViewById(R.id.tvHello);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActionText);
                sendOrderedBroadcast(intent, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        //实例化广播接收器A和B
//        mOrderBroadcastReceiver = new OrderBroadcastReceiver();
//        mNormalBroadcastReceiver = new NormalBroadcastReceiver();
//        //添加广播接收器 A 和 B 的对象，以及优先级
//        registerBroadcastReceiver(mOrderBroadcastReceiver, 1);
//        registerBroadcastReceiver(mNormalBroadcastReceiver, 100);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        //解除注册广播A
//        unregisterReceiver(mOrderBroadcastReceiver);
//        //解除注册广播B
//        unregisterReceiver(mNormalBroadcastReceiver);
    }

    /**
     * 注册广播
     */
    private <T extends BroadcastReceiver> void registerBroadcastReceiver(T broadcastReceiver, int priority) {
        IntentFilter filter = new IntentFilter();
        //如果不设定优先级默认为0
        //设定优先级，我们将 广播A设定优先级为1
        filter.setPriority(priority);
        //添加action
        filter.addAction(mActionText);
        //注册广播接收器
        registerReceiver(broadcastReceiver, filter);
    }


}
