package com.cloud.cloud_backend_service_client.service;

import org.springframework.cloud.openfeign.FeignClient;
import com.cloud.cloud_backend_model.user.entity.User;
import com.cloud.cloud_backend_model.user.VO.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@FeignClient(name = "cloud-backend-user-service", path = "/api/user/inner")
public interface UserFeignClient {
    /**
     * 根据 id 获取用户
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
    User getById(@RequestParam("userId") long userId);

    /**
     * 根据 id 获取用户列表
     * @param idList
     * @return
     */
    @GetMapping("/get/ids")
    List<User> listByIds(@RequestParam("idList") Collection<Long> idList);


    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    @GetMapping("/get/user")
    User getLoginUser(HttpServletRequest request);

    /**
     * 判断是否为管理员
     * @param user
     * @return
     */
    @GetMapping("/validate-admin")
    boolean isAdmin(User user);

    /**
     * 判断是否为管理员
     * @param request
     * @return
     */
    @GetMapping("/validate-admin-request")
    boolean isAdmin(HttpServletRequest request);

    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
    @GetMapping("/get/user-vo")
    UserVO getUserVO(User user);

}

