package com.william.controller;

import com.william.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回字符串
     * @param model
     * @return
     */
    @RequestMapping("/testRespString")
    public String testRespString(Model model){
        System.out.println("testRespString()执行了。。。");
        //模拟从数据库中查询出来数据
        User user = new User();
        user.setUsername("林作亮");
        user.setPassword("123456");
        user.setAge(22);

        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 返回为空
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testRespVoid")
    public void testRespVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testRespVoid()执行了。。。");
        //1.请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //2.重定向
//        String path = request.getContextPath();
//        System.out.println(path);
//        response.sendRedirect(path+"/index.jsp");

        //3.直接响应
        //解决中文乱码问题
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //response.setHeader("content-type","text/html;charset=UTF-8");
        response.getWriter().println("您好");
    }

    /**
     * 返回值为ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView()执行了。。。");
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查询出来数据
        User user = new User();
        user.setUsername("林作亮");
        user.setPassword("12345");
        user.setAge(22);
        //把user对象存储在mv中，底层就是把user存储在request域对象中
        mv.addObject("user",user);
        //指定跳转页面
        mv.setViewName("success");
        return mv;
    }


    /**
     * 用关键字去做转发或重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect()执行了。。。");
        //转发
        //return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax()执行了。。。");
        //客户端发送ajax请求，传入的是json字符串，后端自动把json字符串封装到user对象中（传入字符串名称和user对象的属性名一致）
        System.out.println(user);
        //响应前段请求，模拟数据库查询出来数据后赋值
        user.setUsername("苏");
        user.setAge(88);

        return user;
    }
}
