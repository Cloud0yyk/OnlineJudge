package com.cloud.cloud_backend_user_service.controller.inner;

import com.cloud.cloud_backend_model.user.entity.User;
import com.cloud.cloud_backend_model.user.VO.UserVO;
import com.cloud.cloud_backend_user_service.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@RestController("/api/user/inner")
public class UserInnerController {
    @Resource
    private UserService userService;

    /**
     * 根据 id 获取用户
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
    public User getById(@RequestParam("userId") long userId){
        return userService.getById(userId);
    }

    /**
     * 根据 id 获取用户列表
     * @param idList
     * @return
     */
    @GetMapping("/get/ids")
    public List<User> listByIds(@RequestParam("idList") Collection<Long> idList){
        return userService.listByIds(idList);
    }

    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    // @Override
    @GetMapping("/get/user")
    public User getLoginUser(HttpServletRequest request){
        return userService.getLoginUser(request);
    }

    /**
     * 判断是否为管理员
     * @param user
     * @return
     */
    @GetMapping("/validate-admin")
    public boolean isAdmin(User user){
        return userService.isAdmin(user);
    }

    @GetMapping("/validate-admin-request")
    public boolean isAdmin(HttpServletRequest request){
        return userService.isAdmin(request);
    }

    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
    @GetMapping("/get/user-vo")
    public UserVO getUserVO(User user){
        return userService.getUserVO(user);
    }
}
