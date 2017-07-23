package com.study.framework.day02;

import com.study.framework.day02.dto.UserDTO;
import com.study.framework.day02.view.LoginView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

@SpringUI(path = "/member")
public class InitPage extends UI implements View {
    public static List<String> userid = new ArrayList<String>();
    public static List<String> password = new ArrayList<String>();
    public static Navigator navigator;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        userid.add("admin");
        password.add("1234");

        navigator = new Navigator(this, this);
        getNavigator().addView(LoginView.LoginViewName, LoginView.class);
        getNavigator().setErrorView(LoginView.class);

        getNavigator().navigateTo(LoginView.LoginViewName);
//        navigator.navigateTo(MAINVIEW + "/" + menuitem);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
