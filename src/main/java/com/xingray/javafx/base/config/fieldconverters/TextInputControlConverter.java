package com.xingray.javafx.base.config.fieldconverters;

import com.xingray.java.config.FieldConverter;
import javafx.scene.control.TextInputControl;

public class TextInputControlConverter implements FieldConverter<TextInputControl, String> {

    @Override
    public String getConfig(TextInputControl textInputControl) {
        return textInputControl.getText();
    }

    @Override
    public void restoreConfig(TextInputControl textInputControl, String s) {
        textInputControl.setText(s);
    }
}
