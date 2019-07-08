package com.meicai.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.facebook.react.bridge.ReadableArray;
import com.meicai.picker.view.OnSelectedListener;
import com.meicai.picker.view.PickerViewAlone;
import com.meicai.picker.view.PickerViewLinkage;

public class PickerViewLayout extends LinearLayout {
    private PickerViewLinkage pickerViewLinkage;
    private PickerViewAlone pickerViewAlone;
    private PickerState pickerState;

    public PickerViewLayout(Context context) {
        super(context);
        this.init();
    }

    public PickerViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public PickerViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        pickerState = new PickerState();
    }

    public void setPickerData(ReadableArray pickerData, double[] weights) {
        pickerState.isInit = true;
        String name = pickerData.getType(0).name();
        switch (name) {
            case "Map":
                pickerViewAlone = null;
                if (pickerViewLinkage == null) {
                    pickerViewLinkage = new PickerViewLinkage(getContext());
                }
                this.addView(pickerViewLinkage);
                pickerViewLinkage.setPickerData(pickerData, weights);
                break;
            default:
                pickerViewLinkage = null;
                if (pickerViewAlone == null) {
                    pickerViewAlone = new PickerViewAlone(getContext());
                }
                this.addView(pickerViewAlone);
                pickerViewAlone.setPickerData(pickerData, weights);
                break;
        }
        setPickerState();
    }

    private void setPickerState() {
        setIsLoop(pickerState.isLoop);
        setSelectedListener(pickerState.onSelectedListener);
        setSelectIndex(pickerState.selectIndex);
        setSelectValue(pickerState.selectValue);
        setTextColor(pickerState.textColor);
        setTextSize(pickerState.textSize);
    }

    public void setIsLoop(boolean isLoop) {
        if (pickerState.isInit) {
            if (pickerViewAlone != null) pickerViewAlone.setIsLoop(isLoop);
            if (pickerViewLinkage != null) pickerViewLinkage.setIsLoop((isLoop));
        } else {
            pickerState.isLoop = isLoop;
        }
    }

    public void setSelectValue(String[] selectValue) {
        if (pickerState.isInit && selectValue != null && selectValue.length > 0) {
            if (pickerViewAlone != null) pickerViewAlone.setSelectValue(selectValue);
            if (pickerViewLinkage != null) pickerViewLinkage.setSelectValue((selectValue));
        } else {
            pickerState.selectValue = selectValue;
        }
    }

    public void setSelectIndex(int[] selectIndex) {
        if (pickerState.isInit && selectIndex != null && selectIndex.length > 0) {
            if (pickerViewAlone != null) pickerViewAlone.setSelectIndex(selectIndex);
            if (pickerViewLinkage != null) pickerViewLinkage.setSelectIndex((selectIndex));
        } else {
            pickerState.selectIndex = selectIndex;
        }
    }

    public void setTextColor(int color) {
        if (pickerState.isInit && color != 0) {
            if (pickerViewAlone != null) pickerViewAlone.setTextColor(color);
            if (pickerViewLinkage != null) pickerViewLinkage.setTextColor((color));
        } else {
            pickerState.textColor = color;
        }
    }

    public void setTextSize(float size) {
        if (pickerState.isInit && size != 0) {
            if (pickerViewAlone != null) pickerViewAlone.setTextSize(size);
            if (pickerViewLinkage != null) pickerViewLinkage.setTextSize((size));
        } else {
            pickerState.textSize = size;
        }
    }

    public void setSelectedListener(OnSelectedListener selectedListener) {

        if (pickerState.isInit) {
            if (pickerViewAlone != null) pickerViewAlone.setOnSelectedListener(selectedListener);
            if (pickerViewLinkage != null)
                pickerViewLinkage.setOnSelectListener((selectedListener));
        } else {
            pickerState.onSelectedListener = selectedListener;
        }
    }

    private static final class PickerState {
        boolean isInit;
        int textColor;
        float textSize;
        OnSelectedListener onSelectedListener;
        int[] selectIndex;
        String[] selectValue;
        boolean isLoop;
    }

}
