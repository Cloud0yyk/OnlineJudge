package com.cloud.cloud_backend_user_service.judge.strategy;

import com.cloud.cloud_backend_user_service.model.dto.question.JudgeCase;
import com.cloud.cloud_backend_user_service.judge.codesandbox.model.JudgeInfo;
import com.cloud.cloud_backend_user_service.model.entity.Question;
import com.cloud.cloud_backend_user_service.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
