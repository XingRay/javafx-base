package com.xingray.javafx.base.ui.list;

import com.xingray.java.util.StringUtil;
import com.xingray.javafx.base.page.LayoutPath;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

import java.io.IOException;
import java.lang.reflect.Field;

public abstract class BaseListCell<T> extends ListCell<T> {

    private final Node root;

    public BaseListCell() {
        LayoutPath layoutPathAnnotation = getClass().getAnnotation(LayoutPath.class);
        if (layoutPathAnnotation == null) {
            throw new IllegalStateException("must use with @LayoutPath");
        }
        String layoutPath = layoutPathAnnotation.value();
        if (StringUtil.isEmpty(layoutPath)) {
            throw new IllegalArgumentException("layout path is empty");
        }
        if (!layoutPath.startsWith("/")) {
            throw new IllegalArgumentException("layout path must start with '/'");

        }
        try {
            root = new FXMLLoader().load(getClass().getResource(layoutPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            View viewAnnotation = field.getAnnotation(View.class);
            if (viewAnnotation == null) {
                continue;
            }
            String id = viewAnnotation.value();
            Node childView = findViewById(id);
            if (childView == null) {
                continue;
            }
            field.setAccessible(true);
            try {
                field.set(this, childView);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public <E extends Node> E findViewById(String id) {
        return (E) root.lookup("#" + id);
    }

    @Override
    protected final void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setGraphic(null);
            return;
        }

        refreshItem(item);
        setGraphic(root);
    }

    protected abstract void refreshItem(T item);
}
