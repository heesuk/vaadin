package com.study.framework.day02.view;

import com.study.framework.day02.InitPage;
import com.study.framework.day02.dto.UserDTO;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.util.StringUtils;

import static com.study.framework.day02.InitPage.navigator;
import static com.study.framework.day02.InitPage.userid;

public class LoginView extends VerticalLayout implements View {
    public static final String LoginViewName = "login";

    public LoginView() {

        Panel loginPanel = new Panel();
        loginPanel.setSizeUndefined();
        addComponent(loginPanel);

        FormLayout loginForm = new FormLayout();

        UserDTO user = new UserDTO();
        TextField username = new TextField("username");
        PasswordField password = new PasswordField("password");

        HorizontalLayout btnLayout = new HorizontalLayout();

        Button registerBtn = new Button("register");
        Button loginBtn = new Button("login");
        btnLayout.addComponents(registerBtn, loginBtn);

        loginForm.addComponents(username, password);
        loginForm.addComponent(btnLayout);
        loginPanel.setContent(loginForm);

        setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);

        registerBtn.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                boolean isValid = false;
                if (StringUtils.isEmpty(username.getValue()) || StringUtils.isEmpty(password.isEmpty())) {
                    Notification.show("input id or password plz");
                } else {
                    userid.add(username.getValue());
                    InitPage.password.add(password.getValue());
                }

            }
        });

        loginBtn.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                boolean isValid = false;
                if (userid.contains(username.getValue())) {
                    String list_password = InitPage.password.get(userid.indexOf(username.getValue()));
                    if (list_password.equals(password.getValue())) {
                        Notification.show("collect!");
                        navigator.addView(UserView.UserViewName, UserView.class);
                        navigator.navigateTo("/"+username.getValue());
                    } else {
                        Notification.show("password error", Notification.Type.ERROR_MESSAGE);
                    }
                } else {
                    Notification.show("id error", Notification.Type.ERROR_MESSAGE);
                }
            }
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
