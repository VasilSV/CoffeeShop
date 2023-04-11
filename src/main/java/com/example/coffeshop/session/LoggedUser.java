package com.example.coffeshop.session;

import com.example.coffeshop.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private long id;

    private String userName;

    public void login(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
    }

    public void logout() {
        this.id = 0;
        this.userName = null;
    }

    public long getId() {
        return id;
    }

    public LoggedUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public LoggedUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
