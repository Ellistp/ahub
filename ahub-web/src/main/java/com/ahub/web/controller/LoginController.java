package com.ahub.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.ahub.common.model.ErrorConstant;
import com.ahub.common.model.Result;
import com.ahub.common.utils.CaptchaUtils;
import com.ahub.web.controller.base.BaseController;
import com.ahub.web.csrf.CsrfToken;
import com.ahub.web.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController extends BaseController {
    /**
     * 首页
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    /**
     * GET 登录
     * @return {String}
     */
    @GetMapping("/login")
    @CsrfToken(create = true)
    public String login() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * POST 登录 shiro 写法
     *
     * @param username 用户名
     * @param password 密码
     * @return {Object}
     */
    @PostMapping("/login")
    @CsrfToken(remove = true)
    @ResponseBody
    public Result loginPost(HttpServletRequest request, String username, String password, String captcha,
                            @RequestParam(value = "rememberMe", defaultValue = "1") Integer rememberMe) {
        // 改为全部抛出异常，避免ajax csrf token被刷新
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            throw new RuntimeException("密码不能为空");
        }
        if (StringUtils.isBlank(captcha)) {
            throw new RuntimeException("验证码不能为空");
        }
        if (!CaptchaUtils.validate(request, captcha)) {
            throw new RuntimeException("验证码错误");
        }
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 设置记住密码
        token.setRememberMe(1 == rememberMe);
        try {
            user.login(token);
            return Result.createSuccessResult();
        } catch (UnknownAccountException e) {
            return Result.createFailResult(ErrorConstant.ACCOUNT_NOT_EXIST_ERROR);
        } catch (DisabledAccountException e) {
            return Result.createFailResult(ErrorConstant.ACCOUNT_DISABLED_ERROR);
        } catch (IncorrectCredentialsException e) {
            return Result.createFailResult(ErrorConstant.INCORRECT_CREDENTIALS_ERROR);
        } catch (AuthenticationException e) {
            return Result.createFailResult(ErrorConstant.GENERAL_AUTH_ERROR);
        }
    }

    /**
     * 未授权
     * @return {String}
     */
    @GetMapping("/unauth")
    public String unauth() {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:/login";
        }
        return "unauth";
    }

    /**
     * 退出
     * @return {Result}
     */
    @PostMapping("/logout")
    @ResponseBody
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return renderSuccess();
    }

}
