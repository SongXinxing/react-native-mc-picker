import { requireNativeComponent } from 'react-native';
import React, { Component } from 'react';

const RNPickerView = requireNativeComponent("RNPickerView");

class PickerView extends Component {

  _onPickerSelect(event) {
    if (!this.props.onPickerSelect) {
      return;
    }
    let nativeEvent = event.nativeEvent;
    this.props.onPickerSelect(nativeEvent);
  }

  render() {
    let style = this.props.style ? this.props.style : {};
    let height = style.height ? style.height : 200
    let width = style.width ? style.width : '100%'

    return (
      <RNPickerView
        {...this.props}
        style={[{ height, width }, this.props.style]}
        onPickerSelect={(event) => this._onPickerSelect(event)} />
    )
  }
}

module.exports = PickerView;