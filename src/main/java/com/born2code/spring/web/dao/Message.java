package com.born2code.spring.web.dao;

import com.born2code.spring.web.validation.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    private static final long serialVersionUID = 414529653401096803L;

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 5, max = 100, message = "Subject must be within 5 to 100 characters")
    private String subject;

    @Size(min = 5, max = 255, message = "Content must be within 5 to 255 characters")
    private String content;

    /**
     * Sender's Name
     */
    @Size(min = 4, max = 60, message = "Name must be within 4 to 60 characters")
    private String name;

    /**
     * Sender's Email
     */
    @ValidEmail
    private String email;
    private String username;

    public Message() {

    }

    public Message(String subject, String content, String name, String email, String username) {
        this.subject = subject;
        this.content = content;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
