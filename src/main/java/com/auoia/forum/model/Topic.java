package com.auoia.forum.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToMany
    List<Post> postList;

    public String title;
    public String body;
    public LocalDate creationDate;
    public LocalDate editDate;
    public Boolean isSticky;

    public Topic() {}

    public Topic(List<Post> postList, String title, String body, LocalDate creationDate, LocalDate editDate, Boolean isSticky) {
        this.postList = postList;
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.editDate = editDate;
        this.isSticky = isSticky;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }

    public Boolean getSticky() {
        return isSticky;
    }

    public void setSticky(Boolean sticky) {
        isSticky = sticky;
    }
}
