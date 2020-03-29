#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint devicetheme.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'devicetheme'
  s.version          = '0.0.1'
  s.summary          = 'A Flutter package to read and return the device theme and set app theme'
  s.description      = <<-DESC
  A Flutter package to read and return the device theme and set app theme
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Laksitha Kumara' => 'laksithakumara@gmail.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.platform = :ios, '8.0'

  # Flutter.framework does not contain a i386 slice. Only x86_64 simulators are supported.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'VALID_ARCHS[sdk=iphonesimulator*]' => 'x86_64' }
  s.swift_version = '5.0'
end
