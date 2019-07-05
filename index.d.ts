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

  pickerFontColor?: Array<number>;

  pickerData?: Array;

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
