package com.acm.front.Dao;

import java.io.Serializable;

public class TaskItemDTO implements Serializable {
    private double averageJudgeFinish;

    // 省略构造方法和其他属性的setter/getter方法

    public void setAverageJudgeFinish(double averageJudgeFinish) {
        this.averageJudgeFinish = averageJudgeFinish;
    }

    public double getAverageJudgeFinish() {
        return averageJudgeFinish;
    }
}
