package com.xmxy.action;

import com.xmxy.base.Const;
import com.xmxy.entity.UserInfo;
import com.xmxy.service.UserService;
import com.xmxy.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @ClassName ManagerConterller
 * @Author Administrator
 * @Date 2019/1/22 0022 17:14
 * 本类用于处理一系列管理应用业务事务
 **/
@Controller
@RequestMapping("/manage")
public class ManagerConterller {
    @Autowired
    private UserService userService;

    /**
     * 用户登录方法
     * @param session 绘画对象
     * @return
     */
    @RequestMapping(value="/login",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(UserInfo user,HttpSession session){
      String res;
      String str=session.getAttribute(Const.PickCode).toString();
      System.out.println(str+":"+user.getRegCode());
      if (!str.equalsIgnoreCase(user.getRegCode())) {
          res = "验证码错误!";
      }else if (!CommonUtil.isNull(userService.login(user))){
            res="正确";
            session.setAttribute("user",user);
            session.removeAttribute("loginMsg");
      }else{
          res="用户名或者密码错误!请重新输入!";
      }
       return res;
    }
}
