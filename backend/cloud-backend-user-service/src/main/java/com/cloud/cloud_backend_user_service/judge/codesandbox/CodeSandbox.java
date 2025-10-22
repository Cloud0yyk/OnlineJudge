package com.cloud.cloud_backend_user_service.judge.codesandbox;

import com.cloud.cloud_backend_user_service.judge.codesandbox.model.ExecuteCodeRequest;
import com.cloud.cloud_backend_user_service.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
