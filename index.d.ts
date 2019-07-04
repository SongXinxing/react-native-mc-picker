declare module 'react-native-mc-picker' {
  import { Component } from 'react'
  import { StyleObj } from 'react-native/Libraries/StyleSheet/StyleSheetTypes'

  export interface PickerViewProperties {
    pickerFontSize?: number;

    pickerData?: any[];

    selectedValue?: any[];

    isLoop?: boolean;

    style?: StyleObj;

    onPickerSelect?(data: any[]): void;
  }

  export class PickerView extends Component<PickerViewProperties> {
  }

  interface PickerOptions {

    pickerData?: any[]


    selectedValue?: any[]


    pickerTitleText?: string

    pickerConfirmBtnText?: string


    pickerCancelBtnText?: string

    pickerConfirmBtnColor?: number[]


    pickerCancelBtnColor?: number[]

    pickerTitleColor?: number[]


    pickerToolBarBg?: number[]

    pickerBg?: number[]


    pickerToolBarFontSize?: number


    pickerFontSize?: number

    pickerRowHeight?: number

    pickerFontColor?: number[]


    onPickerConfirm?(item: any[]): void

    onPickerCancel?(item: any[]): void


    onPickerSelect?(item: any[]): void
  }

  export class NativePicker {

    static init(options: PickerOptions): void


    static show(): void

    static hide(): void


    static toggle(): void


    static select(item: any[]): void

    static isPickerShow(fn?: (err: any, message: any) => void): boolean
  }
}

