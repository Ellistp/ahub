package com.ahub.common.model;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/21
 */
public class ErrorConstant {

    public static final ErrorCode SYS_ERR = new ErrorCode("SysError", "系统错误");

    public static final ErrorCode NOT_LOGIN_ERROR = new ErrorCode("NotLoginError","未登录");

    public static final ErrorCode ACCOUNT_NOT_EXIST_ERROR = new ErrorCode("AccountNotExistError","账户名不存在");

    public static final ErrorCode ACCOUNT_PWD_ERROR = new ErrorCode("AccountPwdError","账户名或密码错误");

    public static final ErrorCode ACCOUNT_DISABLED_ERROR = new ErrorCode("AccountDisabledError","账户未启用");

    public static final ErrorCode GENERAL_AUTH_ERROR = new ErrorCode("AuthError", "登录失败");

    public static final ErrorCode INCORRECT_CREDENTIALS_ERROR = new ErrorCode("IncorrectCredentialsError", "授权认证失败");
}
