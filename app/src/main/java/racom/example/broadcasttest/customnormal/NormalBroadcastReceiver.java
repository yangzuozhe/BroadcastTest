package racom.example.broadcasttest.customnormal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 继承 BroadcastReceiver 基类
 *
 * @author HB.yangzuozhe
 * @date 2021-02-07
 */
public class NormalBroadcastReceiver extends BroadcastReceiver {
    /**
     * 复写 onReceive 方法
     * 接收到广播自动调用这个类的方法
     *
     * @param context
     * @param intent  通过 sendBroadcast 方法传过来的 intent 的值，包名 + 自定义名字
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收广播后的操作
        Toast.makeText(context, "自定义普通广播", Toast.LENGTH_SHORT).show();
    }

}
