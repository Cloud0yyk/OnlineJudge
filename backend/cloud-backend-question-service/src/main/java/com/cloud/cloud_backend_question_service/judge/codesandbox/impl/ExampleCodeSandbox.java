package com.cloud.cloud_backend_question_service.judge.codesandbox.impl;

import com.cloud.cloud_backend_question_service.judge.codesandbox.CodeSandbox;
import com.cloud.cloud_backend_model.codesandbox.ExecuteCodeRequest;
import com.cloud.cloud_backend_model.codesandbox.ExecuteCodeResponse;
import com.cloud.cloud_backend_model.codesandbox.JudgeInfo;
import com.cloud.cloud_backend_model.questionSubmit.enums.JudgeInfoMessageEnum;
import com.cloud.cloud_backend_model.questionSubmit.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
