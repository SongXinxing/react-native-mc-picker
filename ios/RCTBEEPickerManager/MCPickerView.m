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
@property (nonatomic, strong) NSArray * selectValue;// 默认选择项

@property (nonatomic, strong) NSDictionary * pickerData; // 数据源

@property(strong,nonatomic)NSString *pickerFontSize;
@property(strong,nonatomic)NSString *pickerFontFamily;
@property(strong,nonatomic)NSArray *pickerFontColor;
@property(strong,nonatomic)NSString *pickerRowHeight;

@property(nonatomic,strong)BzwPicker *pick;

@end

@implementation MCPickerView

-(instancetype)init {
    self = [super init];
    return self;
}

- (void)setSelectValue:(NSArray *)selectValue {
    _selectValue = selectValue;
    if (_pick) {
        _pick.selectValueArry = selectValue;
        [_pick selectRow];
    }
}

-(void) setPickerData:(NSArray *)pickerData
{
    NSDictionary * dataDic=[[NSMutableDictionary alloc]init];
    [dataDic setValue:pickerData forKey:@"pickerData"];
    _pickerData = dataDic;
    _pick = [[BzwPicker alloc] initWithFrame:CGRectMake(0, 0, SCREEN_WIDTH, 200)
                                         dic:_pickerData selectValueArry:@[@1] weightArry:@[@1,@1,@1] pickerFontSize:@16 pickerFontColor:@[@31,@31,@31,@1] pickerRowHeight:@"30" pickerFontFamily:@""];
    _pick.bolock=^(NSDictionary *backinfoArry){
        if (self.onPickerSelect) {
            self.onPickerSelect(backinfoArry);
        }
    };
    if (_selectValue) {
        _pick.selectValueArry = _selectValue;
        [_pick selectRow];
    }
    [self addSubview:_pick];
}

@end
