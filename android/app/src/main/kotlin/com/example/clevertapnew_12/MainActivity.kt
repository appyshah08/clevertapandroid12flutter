package com.example.clevertapnew_12

import io.flutter.embedding.android.FlutterActivity
import android.content.Context
import android.os.Bundle
import com.clevertap.android.sdk.CleverTapAPI
import io.flutter.app.FlutterApplication
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugin.common.PluginRegistry.PluginRegistrantCallback
//import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService
import io.flutter.view.FlutterMain
import java.util.*
import android.util.Log

import android.content.Intent
import android.os.Build


class MainActivity: FlutterActivity() {

        var cleverTapDefaultInstance: CleverTapAPI? = null

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
   }
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        // On Android 12 and above, inform the notification click to get the above mentioned callback on dart side.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            cleverTapDefaultInstance?.pushNotificationClickedEvent(intent!!.extras)
        }
    }

}

