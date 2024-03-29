package com.example.notificationadvanced.part7;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.notificationadvanced.MainActivity;
import com.example.notificationadvanced.Message;

public class DirectReplyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);

        if (remoteInput != null) {
            CharSequence replyText = remoteInput.getCharSequence("key_text_reply");
            Message answer = new Message(replyText, null);
            MainActivity.MESSAGES.add(answer);

            MainActivity.sendChannel1Notification(context);
        }
    }
}
