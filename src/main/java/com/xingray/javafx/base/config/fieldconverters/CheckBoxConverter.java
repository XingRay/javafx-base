package com.xingray.javafx.base.config.fieldconverters;

import com.xingray.java.config.FieldConverter;
import javafx.scene.control.CheckBox;

public class CheckBoxConverter implements FieldConverter<CheckBox, String> {
    @Override
    public String getConfig(CheckBox checkBox) {
        return checkBox.isSelected() ? "1" : "0";
    }

    @Override
    public void restoreConfig(CheckBox checkBox, String s) {
        checkBox.setSelected("1".equals(s));
    }
}
