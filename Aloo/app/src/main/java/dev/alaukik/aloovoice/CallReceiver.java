package dev.alaukik.aloovoice;

import android.content.*;
import android.telephony.TelephonyManager;
import android.telecom.TelecomManager;
import android.os.Handler;
import android.os.Looper;

public class CallReceiver extends BroadcastReceiver {
    private static final Handler H=new Handler(Looper.getMainLooper());
    private static Runnable pending;
    @Override public void onReceive(Context c, Intent i) {
        String state=i.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
            if(pending!=null) H.removeCallbacks(pending);
            pending=()->answer(c.getApplicationContext());
            H.postDelayed(pending,20000);
        } else if (pending!=null) {
            H.removeCallbacks(pending); pending=null;
        }
    }
    private static void answer(Context c) {
        try {
            TelecomManager tm=(TelecomManager)c.getSystemService(Context.TELECOM_SERVICE);
            tm.acceptRingingCall();
        } catch(Throwable ignored) {
            RootShell.run("input keyevent KEYCODE_HEADSETHOOK");
        }
        // Audio injection/capture is intentionally capability-dependent; next layer probes ROM audio paths.
    }
}
