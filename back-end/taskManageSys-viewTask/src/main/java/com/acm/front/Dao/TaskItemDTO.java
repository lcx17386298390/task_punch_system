package com.acm.front.Dao;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaskItemDTO implements Serializable {
    private BigDecimal averageJudgeFinish;

    // 省略构造方法和其他属性的setter/getter方法

    public void setAverageJudgeFinish(BigDecimal averageJudgeFinish) {
        this.averageJudgeFinish = averageJudgeFinish;
    }

    public BigDecimal getAverageJudgeFinish() {
        return averageJudgeFinish;
    }
}
