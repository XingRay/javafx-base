package com.xingray.javafx.base.config.fieldconverters;

import com.xingray.java.config.FieldConverter;
import javafx.scene.control.DatePicker;

public class DatePickerConverter implements FieldConverter<DatePicker, String> {

    @Override
    public String getConfig(DatePicker datePicker) {
        return datePicker.getEditor().getText();
    }

    @Override
    public void restoreConfig(DatePicker datePicker, String s) {
        datePicker.getEditor().setText(s);
    }
}
