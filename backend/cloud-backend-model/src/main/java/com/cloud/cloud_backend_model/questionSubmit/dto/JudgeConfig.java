package com.cloud.cloud_backend_model.questionSubmit.dto;

import lombok.Data;

/**
 * 题目配置
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制(ms)
     */
    private long timeLimit;

    /**
     * 内存限制(KB)
     */
    private long memoryLimit;

    /**
     * 栈顶限制(KB)
     */
    private long stackLimit;
}
