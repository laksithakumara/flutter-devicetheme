/// Copyright (c) 2019, Laksitha Kumara. All rights reserved. Use of this source code
/// is governed by an Apache License 2.0 that can be found in the LICENSE file.
/// 
import 'dart:async';
import 'dart:developer';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';

class Devicetheme {
  static const MethodChannel _channel = const MethodChannel('devicetheme');

  static Future<String> getTheme() async {
    final String theme = await _channel.invokeMethod('getTheme');
    return theme;
  }
  /// Returns a [String] of the currently set DEVICE theme
  /// (e.g. light or dark)
  static Future<String> get platformTheme async {
    final String theme = await _channel.invokeMethod('getTheme');
    return theme;
  }

  /// Returns a [String] of the currently set APP theme
  /// (e.g. light or dark)
  static Future<String> get appTheme async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    final String theme = prefs.getString("theme") ?? "_";
    if (theme == "_"){
      final String theme = await getTheme();
      prefs.setString('theme', theme);
      return theme;
    }else{
      return theme;
    }
  }
  
  ///Set App theme in SharedPreferences.
  static Future<void> setAppTheme(String theme) async{
    SharedPreferences prefs = await SharedPreferences.getInstance();
    prefs.setString('theme', theme);
  }
}
