import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:devicetheme/devicetheme.dart';

void main() {
  const MethodChannel channel = MethodChannel('devicetheme');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return 'light';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getTheme', () async {
    expect(await Devicetheme.platformTheme, 'light');
  });
}
