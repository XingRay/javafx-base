module com.xingray.javafx.base {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires com.xingray.java.config;
    requires com.xingray.java.util;
    requires com.xingray.java.base;

    exports com.xingray.javafx.base;
    exports com.xingray.javafx.base.config;
    exports com.xingray.javafx.base.config.fieldconverters;
    exports com.xingray.javafx.base.page;
    exports com.xingray.javafx.base.ui.list;
    exports com.xingray.javafx.base.ui.view.interfaces;

}