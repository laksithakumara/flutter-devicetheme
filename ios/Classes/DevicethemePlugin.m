#import "DevicethemePlugin.h"
#if __has_include(<devicetheme/devicetheme-Swift.h>)
#import <devicetheme/devicetheme-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "devicetheme-Swift.h"
#endif

@implementation DevicethemePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftDevicethemePlugin registerWithRegistrar:registrar];
}
@end
