module com.xingray.javafx.base {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires com.xingray.java.config;
    requires com.xingray.java.util;

    exports com.xingray.javafx.base;
    exports com.xingray.javafx.base.config;
    exports com.xingray.javafx.base.config.fieldconverters;
    exports com.xingray.javafx.base.page;
}