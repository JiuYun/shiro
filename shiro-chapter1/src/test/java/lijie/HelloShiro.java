package lijie;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;



/***
 *
 * Shiro tutorial Taoge try again
 * Today 2017-04-01
 *
 * 1.在pom中引入Shiro
 *
 *
 */
public class HelloShiro {




    @Test
    public void testshiro(){

        //1.得要SecurityManager工厂
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken up = new UsernamePasswordToken("zhang","123");

        try{
            subject.login(up);
        }catch (Exception e){
            e.printStackTrace();
        }







    }




















}
