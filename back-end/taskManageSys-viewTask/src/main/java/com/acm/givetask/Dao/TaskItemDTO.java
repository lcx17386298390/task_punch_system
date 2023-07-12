package com.acm.givetask.Dao;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaskItemDTO implements Serializable {
    private BigDecimal averageJudgeFinish;

    // 省略构造方法和其他属性的setter/getter方法

    public BigDecimal setAverageJudgeFinish(BigDecimal averageJudgeFinish) {
        this.averageJudgeFinish = averageJudgeFinish;
        return averageJudgeFinish;
    }

    public BigDecimal getAverageJudgeFinish() {
        return averageJudgeFinish;
    }
}
