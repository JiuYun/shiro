package com.github.jiuyun.shiro.chapter12.credentials;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String,AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        String userName = (String) token.getPrincipal();

        AtomicInteger retry = passwordRetryCache.get(userName);
        if(retry == null){
            retry = new AtomicInteger(0);
            passwordRetryCache.put(userName,retry);
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
