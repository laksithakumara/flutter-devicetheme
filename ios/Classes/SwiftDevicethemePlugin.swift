import Flutter
import UIKit

public class SwiftDevicethemePlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "devicetheme", binaryMessenger: registrar.messenger())
    let instance = SwiftDevicethemePlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    if #available(iOS 12.0, *) {
      switch UIScreen.main.traitCollection.userInterfaceStyle {
        case .dark:result("night") // put your dark mode code here
        case .light: result("light")
        case .unspecified: result("light")
      }
    } else {
        result("light")
    }
    //result("iOS " + UIDevice.current.systemVersion)
  }
}
