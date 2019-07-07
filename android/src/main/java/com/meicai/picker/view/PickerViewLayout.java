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

    public PickerViewLayout(Context context) {
        super(context);
    }

    public PickerViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PickerViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPickerData(ReadableArray pickerData, double[] weights) {
        String name = pickerData.getType(0).name();
        switch (name) {
            case "Map":
                if (pickerViewLinkage == null) {
                    pickerViewLinkage = new PickerViewLinkage(getContext());
                }
                this.addView(pickerViewLinkage);
                pickerViewLinkage.setPickerData(pickerData, weights);
//                pickerViewLinkage.setIsLoop(false);
                break;
            default:
                if (pickerViewAlone == null) {
                    pickerViewAlone = new PickerViewAlone(getContext());
                }
                this.addView(pickerViewAlone);
                pickerViewAlone.setPickerData(pickerData, weights);
//                pickerViewAlone.setIsLoop(false);

                break;
        }
    }

    public void setIsLoop(boolean isLoop) {
        if (pickerViewAlone != null) pickerViewAlone.setIsLoop(isLoop);
        if (pickerViewLinkage != null) pickerViewLinkage.setIsLoop((isLoop));
    }

    public void setSelectValue(String[] selectValue) {
        if (pickerViewAlone != null) pickerViewAlone.setSelectValue(selectValue);
        if (pickerViewLinkage != null) pickerViewLinkage.setSelectValue((selectValue));
    }

    public void setSelectIndex(int[] selectValue) {
        if (pickerViewAlone != null) pickerViewAlone.setSelectIndex(selectValue);
        if (pickerViewLinkage != null) pickerViewLinkage.setSelectIndex((selectValue));
    }

    public void setTextColor(int color) {
        if (pickerViewAlone != null) pickerViewAlone.setTextColor(color);
        if (pickerViewLinkage != null) pickerViewLinkage.setTextColor((color));
    }

    public void setTextSize(float size) {
        if (pickerViewAlone != null) pickerViewAlone.setTextSize(size);
        if (pickerViewLinkage != null) pickerViewLinkage.setTextSize((size));
    }

    public void setSelectedListener(OnSelectedListener selectedListener) {
        if (pickerViewAlone != null) pickerViewAlone.setOnSelectedListener(selectedListener);
        if (pickerViewLinkage != null) pickerViewLinkage.setOnSelectListener((selectedListener));
    }

}
