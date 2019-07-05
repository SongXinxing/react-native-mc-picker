import { requireNativeComponent } from 'react-native';
import React, { Component, memo } from 'react';

const RNPickerViewBase = requireNativeComponent("RNPickerView");

// pickerData
// isLoop
// selectedValue
// pickerFontColor
// pickerFontSize

class MCPickerView extends Component {
  _onPickerSelect = (event) => {
    event.persist();
    let nativeEvent = event.nativeEvent;
    this.props.onPickerSelect && this.props.onPickerSelect(nativeEvent);
  }

  render() {
    let style = this.props.style ? this.props.style : {};
    let height = style.height ? style.height : 200
    let width = style.width ? style.width : '100%'

    return (
      <RNPickerViewBase
        {...this.props}
        style={[{ height, width }, this.props.style]}
        onPickerSelect={this._onPickerSelect} />
    )
  }
}

module.exports = MCPickerView
