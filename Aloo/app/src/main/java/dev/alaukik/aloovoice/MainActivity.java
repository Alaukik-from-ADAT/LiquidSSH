package dev.alaukik.aloovoice;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        TextView v = new TextView(this);
        v.setPadding(48,64,48,48);
        v.setTextSize(20);
        v.setText("Aloovoice\n\nLocal voicemail: ON\nAnswer delay: 20 seconds\n\nRoot: " + (RootShell.available()?"granted/available":"not available") + "\n\nKeep this app allowed to run in background.");
        setContentView(v);
        requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE,Manifest.permission.READ_CALL_LOG,Manifest.permission.READ_CONTACTS,Manifest.permission.RECORD_AUDIO,Manifest.permission.ANSWER_PHONE_CALLS},42);
    }
}
