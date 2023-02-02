package com.xingray.javafx.base.page;


import com.xingray.java.util.StringUtil;

public class PageUtil {
    public static String getLayoutPath(Class<?> cls) {
        LayoutPath layoutPathAnnotation = cls.getAnnotation(LayoutPath.class);
        if (layoutPathAnnotation == null) {
            throw new IllegalArgumentException("class:" + cls.getName() + " is not annotated by " + LayoutPath.class.getName());
        }
        String path = layoutPathAnnotation.value();
        if (StringUtil.isEmpty(path)) {
            throw new IllegalArgumentException("class:" + cls.getName() + " @" + LayoutPath.class.getName() + " param is empty");
        }
        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("class:" + cls.getName() + " @" + LayoutPath.class.getSimpleName() + " param error, path must start with / , like /fxml/layout.fxml");
        }
        return path;
    }
}
