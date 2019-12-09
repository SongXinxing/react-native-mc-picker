//
//  MCPickerView.m
//  AFNetworking
//
//  Created by 宋新星 on 2019/7/4.
//

#import "MCPickerView.h"
#import "BzwPicker.h"

@interface MCPickerView()


@property (nonatomic, copy) RCTBubblingEventBlock onPickerSelect; // picker 选择触发
@property (nonatomic, strong) NSArray * selectedValue;// 默认选择项

@property (nonatomic, strong) NSDictionary * pickerData; // 数据源

@property(strong, nonatomic)NSNumber *pickerFontSize;
@property(strong, nonatomic)NSString *pickerFontFamily;
@property(strong, nonatomic)NSArray *pickerFontColor;
@property(strong, nonatomic)NSString *pickerRowHeight;
@property(strong, nonatomic)NSString *pickerRowWidth;

@property(nonatomic, strong)BzwPicker *pick;

@end

@implementation MCPickerView

-(instancetype)init {
    self = [super init];
    _pickerRowHeight = @"30";
    return self;
}

- (void)setSelectedValue:(NSArray *)selectedValue {
    _selectedValue = selectedValue;
    if (_pick) {
        _pick.selectValueArry = selectedValue;
        [_pick selectRow];
    }
}

-(void) setPickerData:(NSArray *)pickerData
{
    NSDictionary * dataDic=[[NSMutableDictionary alloc]init];
    [dataDic setValue:pickerData forKey:@"pickerData"];
    _pickerData = dataDic;
    if (_pick) {
        [self initPick];
    }
}
// 字体 颜色
//-(void) setPickerFontColor:(NSArray *)pickerFontColor {
//    _pickerFontColor = pickerFontColor;
//}
// 字体 大小
-(void) setPickerFontSize:(NSNumber *)pickerFontSize {
    _pickerFontSize = pickerFontSize;
    if (_pick) {
        [self.pick resetFontSize:pickerFontSize];
    }
}
-(void) setPickerRowHeight:(NSString *)pickerRowHeight {
    _pickerRowHeight = pickerRowHeight;
    if (_pick) {
        [self initPick];
    }
}
-(void) setPickerRowWidth:(NSString *)pickerRowWidth {
    _pickerRowWidth = pickerRowWidth;
    if (_pick) {
        [self initPick];
    }
}

// 所有属性改变之后调用
-(void) didSetProps: (NSArray<NSString *> *)changedProps {
}

- (void)initPick {
    if (_pick != nil) {
        [self.pick removeFromSuperview];
    }
    _pick = [[BzwPicker alloc] initWithFrame:CGRectMake(0, 0, self.frame.size.width, self.frame.size.height) dic:_pickerData selectValueArry:_selectedValue weightArry:@[@1,@1] pickerFontSize:_pickerFontSize pickerFontColor:_pickerFontColor pickerRowHeight:_pickerRowHeight pickerRowWidth:_pickerRowWidth pickerFontFamily:@""];
    __weak typeof(self) weakSelf = self;
    _pick.bolock=^(NSDictionary *backinfoArry){
        if (weakSelf.onPickerSelect) {
            weakSelf.onPickerSelect(backinfoArry);
        }
    };
    [self addSubview: _pick];
}

-(void)layoutSubviews {
    [super layoutSubviews];
    [self initPick];
}

@end
