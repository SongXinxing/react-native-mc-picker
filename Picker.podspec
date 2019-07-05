require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|

  s.name           = 'MCPicker'
  s.version        = package['version'].gsub(/v|-beta/, '')
  s.summary        = package['description']
  s.author         = package['author']
  s.license        = package['license']
  s.homepage       = package['homepage']
  s.source         = { :git => 'https://github.com/SongXinxing/react-native-mc-picker.git', :tag => "v#{s.version}"}
  s.platform       = :ios, '8.0'
  s.preserve_paths = '*.js'

  s.dependency 'React'
  s.subspec 'Core' do |ss|
    ss.source_files = 'ios/RCTBEEPickerManager/*.{h,m}'
    ss.public_header_files = ['ios/RCTBEEPickerManager/*.h']
  end

end
