import {
  requireNativeComponent,
  Platform,
  ViewPropTypes
} from 'react-native';
import React, { Component, memo } from 'react';
import PropTypes from 'prop-types'

let RNPickerViewBase
if (Platform.OS === 'ios') {
  RNPickerViewBase = requireNativeComponent("MCPickerView");
} else {
  RNPickerViewBase = requireNativeComponent("RNPickerView");
}


class MCPicker extends Component {
  _onPickerSelect = (event) => {
    event.persist();
    let nativeEvent = event.nativeEvent;
    this.props.onPickerSelect && this.props.onPickerSelect(nativeEvent);
  }

  render() {
    let {
      style = null,
      pickerFontColor = [31, 31, 31, 1],
      pickerFontSize = 16,
      ...props
    } = this.props
    return (
      <RNPickerViewBase
        {...props}
        style={[{ height: 200, width: '100%' }, style]}
        pickerFontColor={pickerFontColor}
        pickerFontSize={pickerFontSize}
        onPickerSelect={this._onPickerSelect} />
    )
  }
}


MCPicker.propTypes = {
  ...ViewPropTypes,
  pickerData: PropTypes.array.isRequired,
  isLoop: PropTypes.bool, // android only
  selectedValue: PropTypes.array,
  pickerFontColor: PropTypes.array, // [31, 31, 31, 1]
  pickerFontSize: PropTypes.string
}

module.exports = MCPicker
