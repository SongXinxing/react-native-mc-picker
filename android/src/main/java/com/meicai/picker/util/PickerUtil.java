package com.meicai.picker.util;

import com.facebook.react.bridge.ReadableArray;

public class PickerUtil {

    public static int[] getColor(ReadableArray array) {
        int[] colors = new int[4];
        for (int i = 0; i < array.size(); i++) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                    colors[i] = array.getInt(i);
                    break;
                case 3:
                    colors[i] = (int) (array.getDouble(i) * 255);
                    break;
                default:
                    break;
            }
        }
        return colors;
    }

    public static String[] getSelectedValue(ReadableArray array) {
        String[] selectValue = new String[array.size()];
        String value = "";
        for (int i = 0; i < array.size(); i++) {
            switch (array.getType(i).name()) {
                case "Boolean":
                    value = String.valueOf(array.getBoolean(i));
                    break;
                case "Number":
                    try {
                        value = String.valueOf(array.getInt(i));
                    } catch (Exception e) {
                        value = String.valueOf(array.getDouble(i));
                    }
                    break;
                case "String":
                    value = array.getString(i);
                    break;
            }
            selectValue[i] = value;
        }
        return selectValue;
    }
}
