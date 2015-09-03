package com.born2code.spring.web.dao;

import javax.validation.constraints.Size;

public class Notice {
    private int id;

    private User user;

    @Size(min = 5, max = 255, message = "Text must be between 6 and 255 characters.")
    private String text;

    public Notice() {

    }

    public Notice(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Notice(int id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return user.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notice notice = (Notice) o;

        if (!user.equals(notice.user)) return false;
        return text.equals(notice.text);

    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}