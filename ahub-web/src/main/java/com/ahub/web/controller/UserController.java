package com.ahub.web.controller;

import com.ahub.common.model.Result;
import com.ahub.user.service.IUserService;
import com.ahub.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description：用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户管理页
     *
     * @return
     */
    @GetMapping("/manager")
    public String manager() {
        return "admin/user";
    }

    @RequestMapping("/get")
    public Result get() {
        return Result.createSuccessResult(iUserService.selectByAccount("test").getPassword() +  "============" + iUserService.selectById(13L).getPhone());
    }
}
