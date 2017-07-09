package com.github.jiuyun.shiro.chapter13.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/***
 *
 *
 * 凭证匹配器 (干啥玩意儿的?)
 *
 *
 *
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    /***
     *
     * 缓存账户登录错误次数
     *
     */
    private Cache<String,AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager){
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }


    /***
     *
     * 重写密码验证,
     * 1.获取当前用户登录错误次数,每次登录记录一次，登录成功后清除次数,如果尝试错误次数大于5次的将冻结账户
     *
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String userName = (String) token.getPrincipal();

        AtomicInteger retry = passwordRetryCache.get(userName);
        if(retry == null){
            retry = new AtomicInteger(0);
        }

        if(retry.incrementAndGet() > 5){
            throw new ExcessiveAttemptsException();
        }


        boolean matches = super.doCredentialsMatch(token,info);
        if(matches){
            passwordRetryCache.remove(userName);
        }
        return matches;

    }
}
