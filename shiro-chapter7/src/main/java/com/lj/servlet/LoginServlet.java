package com.lj.servlet;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 *
 * 处理用户登录登出操作
 * toDay    2017-06-07
 *
 */

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    /**
     *
     * 登录页面
     *
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
    }


    /***
     *
     * 处理登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");


        System.out.println("userName : "+userName + " , password : " + password);
        String error    = null;

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);

        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            error = "用户名或密码错误";
        }catch (IncorrectCredentialsException e){
            error = "用户名或密码错误";
        }catch (AuthenticationException e){
            error = "其他错误" + e.getMessage();
        }


        if(error != null){
            req.setAttribute("error",error);
            req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("WEB-INF/view/home.jsp").forward(req,resp);
        }
    }






}
