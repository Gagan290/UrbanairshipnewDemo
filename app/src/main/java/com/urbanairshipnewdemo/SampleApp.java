package com.urbanairshipnewdemo;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

/**
 * Created by praveen on 1/2/18.
 */

public class SampleApp extends Autopilot {
    @Override
    public void onAirshipReady(@NonNull UAirship airship) {
        Log.d("meta", "onReady");

        airship.getPushManager().setUserNotificationsEnabled(true);

        // Android O
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = UAirship.getApplicationContext();

            NotificationManager notificationManager = (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);

            @SuppressLint({"StringFormatInvalid", "LocalSuppress"})
            NotificationChannel channel = new NotificationChannel("customChannel",
                    context.getString(R.string.custom_channel_name),
                    NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public AirshipConfigOptions createAirshipConfigOptions(@NonNull Context context) {
//        String channelId = UAirship.shared().getPushManager().getChannelId();
//        Log.d("meta","channel Id " +channelId);

        Log.d("meta", "createConfig");
//        AirshipConfigOptions options = new AirshipConfigOptions.Builder()
//                .setDevelopmentAppKey("VdewLD6OQvGNHhTba_M-Ew")
//                .setDevelopmentAppSecret("7AfQBEPETMahwXNzNm_1LA")
//                .setInProduction(!BuildConfig.DEBUG)
//                .setGcmSender("1029786811393") // FCM/GCM sender ID
//                .setNotificationIcon(R.drawable.ic_notification)
//                .setNotificationChannel("channelId")
//                .build();
//        UAirship.shared().getPushManager().setUserNotificationsEnabled(true);
//        CustomEvent.Builder builder = new CustomEvent.Builder("demo_event")
//                .setEventValue(100);

//        // Record the event
//        UAirship.shared().getAnalytics().addEvent(builder.create());
//        return super.createAirshipConfigOptions(context);

        AirshipConfigOptions.Builder builder = new AirshipConfigOptions.Builder();
        builder.setDevelopmentAppKey("MLnHQoqRSG-p7yn1W2z8vg");
        builder.setDevelopmentAppSecret("WTv7v2r2QveAAVdHp8AMLw");
        builder.setProductionAppKey("Your Production App Key");
        builder.setProductionAppSecret("Your Production App Secret");
        builder.setInProduction(!BuildConfig.DEBUG);
        builder.setFcmSenderId("1029786811393");
        //builder.setGcmSender("Your Google API Project Number");
        builder.setNotificationIcon(R.drawable.ic_notification);
        //builder.setNotificationAccentColor(ContextCompat(getContext(), R.color.accent));
        builder.setNotificationChannel("customChannel");
        AirshipConfigOptions options = builder.build();

        return options;
    }
}
