# Device Theme

A Flutter package to read and return the device theme and set app theme.

## Usage
```dart
import 'package:devicetheme/devicetheme.dart';
```
then

This will return the current device theme.

```dart
String platformTheme = await Devicetheme.platformTheme;
```

This will return saved value in SharedPreferences( if  SharedPreferences is empty we will save current device theme)

```dart
String appTheme = await Devicetheme.appTheme;
```

This will set SharedPreferences theme value.

```dart
await Devicetheme.setAppTheme('light');
```

## Getting Started

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android and/or iOS.

For help getting started with Flutter, view our 
[online documentation](https://flutter.dev/docs), which offers tutorials, 
samples, guidance on mobile development, and a full API reference.
