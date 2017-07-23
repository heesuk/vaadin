package com.study.framework.day02.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

public class UserView extends VerticalLayout implements View {
    public static final String UserViewName = "";
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Panel userPanel = new Panel();

        userPanel.setSizeUndefined();
        addComponent(userPanel);
        setComponentAlignment(userPanel, Alignment.MIDDLE_CENTER);

        FormLayout fom = new FormLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        PasswordField modifyPassword = new PasswordField("변경 PW");
        Button modifyBtn = new Button("change");
        Button deleteBnt = new Button("delete");

        horizontalLayout.addComponents(modifyBtn, deleteBnt);

        Label title = new Label();
        String caption = viewChangeEvent.getParameters() + " 님 안녕하세요";
        title.setCaption(caption);

        fom.addComponents(title, modifyPassword);
        fom.addComponent(horizontalLayout);

        userPanel.setContent(fom);

    }
}
