package racom.example.broadcasttest.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import racom.example.broadcasttest.IOrderClickLister;

/**
 * 有序广播接收
 *
 * @author HB.yangzuozhe
 * @date 2021-02-07
 */
public class OrderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"我是有序广播",Toast.LENGTH_SHORT).show();
    }
}
