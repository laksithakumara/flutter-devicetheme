package com.haburu.theme.devicetheme;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry;

public class DevicethemePlugin implements FlutterPlugin, MethodCallHandler {
  private Context applicationContext;
  private MethodChannel methodChannel;

  /** Plugin registration. */
  public static void registerWith(PluginRegistry.Registrar registrar) {
    final DevicethemePlugin instance = new DevicethemePlugin();
    instance.onAttachedToEngine(registrar.context(), registrar.messenger());
  }

  @Override
  public void onAttachedToEngine(FlutterPluginBinding binding) {
    onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger());
  }
  private void onAttachedToEngine(Context applicationContext, BinaryMessenger messenger) {
    this.applicationContext = applicationContext;
    methodChannel = new MethodChannel(messenger, "devicetheme");
    methodChannel.setMethodCallHandler(this);
  }
  @Override
  public void onDetachedFromEngine(FlutterPluginBinding binding) {
    applicationContext = null;
    methodChannel.setMethodCallHandler(null);
    methodChannel = null;
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getTheme")) {
      result.success(getTheme());
    } else {
      result.notImplemented();
    }
  }

  private String getTheme() {
    try {
      int currentNightMode = applicationContext.getResources().getConfiguration().uiMode
          & Configuration.UI_MODE_NIGHT_MASK;
      switch (currentNightMode) {
      case Configuration.UI_MODE_NIGHT_NO:
        case Configuration.UI_MODE_NIGHT_UNDEFINED:
          return "light";
      case Configuration.UI_MODE_NIGHT_YES:
          return "night";
      }
      return "light";
    } catch (Exception e) {
      return "light";
    }
  }

}