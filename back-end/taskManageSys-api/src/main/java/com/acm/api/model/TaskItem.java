package com.acm.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaskItem implements Serializable {
    private String id;

    private String content;

    private BigDecimal judgefinish;

    private String name;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String publisher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getJudgefinish() {
        return judgefinish;
    }

    public void setJudgefinish(BigDecimal judgefinish) {
        this.judgefinish = judgefinish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}