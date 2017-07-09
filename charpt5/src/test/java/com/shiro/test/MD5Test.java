package com.shiro.test;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

import java.security.Key;

/**
 * Created by Administrator on 2017/7/2 0002.
 */
public class MD5Test {







    @Test
    public void test(){
        String str1 = "Hello";
        String slat = "123";
        System.out.println(new Md5Hash(str1,slat,2).toString().length());
    }


    @Test
    public void testSHA256(){
        String str1 = "hello";
        String slat = "123";
        System.out.println(new Sha256Hash(str1,slat).toString().length());
    }


    @Test
    public void testSimpleHash(){
        String str1 = "hello";
        String slat = "123";
        System.out.println(new SimpleHash("SHA-1",str1,slat).toString());

    }


    @Test
    public void testHashService(){
        DefaultHashService hashService = new DefaultHashService();
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleByteSource("123"));
        hashService.setGeneratePublicSalt(true);
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        hashService.setHashIterations(1);

        HashRequest request = new HashRequest.Builder().setAlgorithmName("MD5")
                .setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123"))
                .setIterations(2).build();

        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);
    }


    @Test
    public void testAesCipherService(){
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);
        Key key = aesCipherService.generateNewKey();
        String text = "hello";

        String enCryptText = aesCipherService.encrypt(text.getBytes(),key.getEncoded()).toHex();
        String text2 = new String(aesCipherService.decrypt(Hex.decode(enCryptText),key.getEncoded()).getBytes());

        System.out.println(enCryptText);
        System.out.println(text2);

    }



    @Test
    public void testSimpleHash2(){

        String algorithmName = "MD5";
        String username = "liu";
        String password = "123";
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;

        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);

        System.out.println(salt1 + salt2);
        System.out.println(hash);
    }





















}
