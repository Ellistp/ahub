package com.ahub.web.shiro;

import java.util.Map;
import java.util.Set;

import com.ahub.common.model.ShiroUser;
import com.ahub.user.model.UserDO;
import com.ahub.user.service.IRoleService;
import com.ahub.user.service.IUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description：shiro权限认证
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
public class ShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(ShiroRealm.class);

    @Autowired
    private IUserService IUserService;

    @Autowired
    private IRoleService IRoleService;
    
    public ShiroRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }
    
    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ----
     * shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UserDO userDO = this.IUserService.selectByAccount(token.getUsername());
        // 账号不存在
        if (userDO == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }

        // 账号未启用
        if (userDO.getStatus() == 1) {
            throw new LockedAccountException();
        }
        // 读取用户的url和角色
        Map<String, Set<String>> resourceMap = IRoleService.selectResourceMapByUserId(userDO.getId());
        Set<String> urls = resourceMap.get("urls");
        Set<String> roles = resourceMap.get("roles");
        ShiroUser shiroUser = new ShiroUser(userDO.getId(), userDO.getAccount(), userDO.getName(), urls);
        shiroUser.setRoles(roles);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, userDO.getPassword().toCharArray(), getName());
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(shiroUser.getRoles());
        info.addStringPermissions(shiroUser.getUrlSet());
        return info;
    }
    
    @Override
    public void onLogout(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        removeUserCache(shiroUser);
    }

    /**
     * 清除用户缓存
     * @param shiroUser
     */
    public void removeUserCache(ShiroUser shiroUser){
        removeUserCache(shiroUser.getLoginName());
    }

    /**
     * 清除用户缓存
     * @param loginName
     */
    public void removeUserCache(String loginName){
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(principals);
    }
}
