package com.acm.model;

import java.io.Serializable;

public class TaskItem implements Serializable {
    private String id;

    private String content;

    private Double judgefinish;

    private String name;

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

    public Double getJudgefinish() {
        return judgefinish;
    }

    public void setJudgefinish(Double judgefinish) {
        this.judgefinish = judgefinish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}