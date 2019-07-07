import * as React from 'react'
import {
    FlexStyle,
    ShadowStyleIOS,
    Picker,
    StyleProp,
    TransformsStyle,
} from 'react-native'

export interface MCPickerStyle extends FlexStyle, TransformsStyle, ShadowStyleIOS {
}

export interface MCPickerProperties {

  pickerFontSize?: string;
  // picker 字体颜色 (anroid only)
  pickerFontColor?: Array<number>;
  // picker 每行的高度 （ios only）
  pickerRowHeight?: string;
  // picker 每行的宽度，设置后 wheelArray 失效 (ios only)
  pickerRowWidth?: string;

  pickerData?: any[];

  selectedValue?: Array<number>;

  isLoop?: boolean;

  style?: StyleProp<MCPickerStyle>;

  onPickerSelect?: (data: []) => void;
}

interface MCPickerStatic extends React.ComponentClass<MCPickerProperties> {
}

declare var MCPicker: MCPickerStatic

type MCPicker = MCPickerStatic

export default MCPicker
