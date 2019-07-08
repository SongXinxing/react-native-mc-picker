import {
  requireNativeComponent,
  Platform,
  ViewPropTypes
} from 'react-native';
import React, { Component, memo } from 'react';
import PropTypes from 'prop-types'

let RNPickerViewBase = requireNativeComponent("MCPickerView");

class MCPicker extends Component {
  _onPickerSelect = (event) => {
    event.persist();
    let nativeEvent = event.nativeEvent;
    this.props.onPickerSelect && this.props.onPickerSelect(nativeEvent);
  }

  render() {
    let {
      pickerFontColor = [31, 31, 31, 1],
      pickerFontSize = 16,
      isLoop = false,
      ...props
    } = this.props
    return (
      <RNPickerViewBase
        {...props}
        isLoop={isLoop}
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
  pickerFontSize: PropTypes.number
}

module.exports = MCPicker
