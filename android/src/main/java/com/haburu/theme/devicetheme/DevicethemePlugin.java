package com.haburu.theme.devicetheme;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import android.content.res.Configuration;

public class DevicethemePlugin implements FlutterPlugin, MethodCallHandler {
  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    final MethodChannel channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "devicetheme");
    channel.setMethodCallHandler(new DevicethemePlugin(flutterPluginBinding));
  }

  // This static function is optional and equivalent to onAttachedToEngine. It supports the old
  // pre-Flutter-1.12 Android projects. You are encouraged to continue supporting
  // plugin registration via this function while apps migrate to use the new Android APIs
  // post-flutter-1.12 via https://flutter.dev/go/android-project-migration.
  //
  // It is encouraged to share logic between onAttachedToEngine and registerWith to keep
  // them functionally equivalent. Only one of onAttachedToEngine or registerWith will be called
  // depending on the user's project. onAttachedToEngine or registerWith must both be defined
  // in the same class.
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "devicetheme");
    channel.setMethodCallHandler(new DevicethemePlugin());
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getTheme")) {
      result.success(getTheme());
    } else {
      result.notImplemented();
    }
  }

  private FlutterPluginBinding mFlutterPlugin;

  public DevicethemePlugin(FlutterPluginBinding flutterPlugin) {
    mFlutterPlugin = flutterPlugin;
  }

  public DevicethemePlugin() {

  }

  private String getTheme() {
    try {
      int currentNightMode = mFlutterPlugin.getApplicationContext().getResources().getConfiguration().uiMode
          & Configuration.UI_MODE_NIGHT_MASK;
      switch (currentNightMode) {
      case Configuration.UI_MODE_NIGHT_NO:
          return "light";
      case Configuration.UI_MODE_NIGHT_YES:
          return "night";
      case Configuration.UI_MODE_NIGHT_UNDEFINED:
          return "light";
      }
      return "error";
    } catch (Exception e) {
      return "error";
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
  }
}