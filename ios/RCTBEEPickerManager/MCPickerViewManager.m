//
//  MCPickerViewManager.m
//  AFNetworking
//
//  Created by 宋新星 on 2019/7/4.
//

#import "MCPickerViewManager.h"
#import "MCPickerView.h"
#import "BzwPicker.h"

@implementation MCPickerViewManager

RCT_EXPORT_MODULE(MCPickerView)

- (MCPickerView *)view
{
    return [[MCPickerView alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(onPickerSelect, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(pickerData, NSArray)
RCT_EXPORT_VIEW_PROPERTY(selectedValue, NSArray)
RCT_EXPORT_VIEW_PROPERTY(pickerFontSize, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(pickerFontFamily, NSString)
RCT_EXPORT_VIEW_PROPERTY(pickerFontColor, NSArray)
RCT_EXPORT_VIEW_PROPERTY(pickerRowHeight, NSString)
RCT_EXPORT_VIEW_PROPERTY(pickerRowWidth, NSString)

@end
