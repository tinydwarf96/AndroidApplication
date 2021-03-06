package com.example.georgealbert.queuemobileapplication;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by George Albert on 12/12/2017.
 */

public class MyFirebaseMessagingServices extends FirebaseMessagingService {
    private static final String TAG = "fcmexamplemessages";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO(developer): Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        notifyUser(remoteMessage.getFrom(), remoteMessage.getNotification().getBody());
    }

    public void notifyUser(String from,String notification){
        MyNoftificationManager myNotificationManager = new MyNoftificationManager(getApplicationContext());
        myNotificationManager.showNotification(from, notification, new Intent(getApplicationContext(), Main3Activity.class));
    }

}
