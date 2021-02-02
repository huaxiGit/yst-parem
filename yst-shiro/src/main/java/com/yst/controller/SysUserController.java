package com.yst.controller;


import com.yst.pojo.UUser;
import com.yst.service.SysUserService;
import com.yst.utilts.GuliException;
import com.yst.utilts.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SysUserController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

   /* @RequestMapping("/getSysUser")
    @ResponseBody
    public JsonResult getSysUser(UUser sysUser) {
        SysUser user = sysUserService.getUserByUserName(sysUser.getUsername());

        return new JsonResult(true, null, user);
    }*/

    @RequestMapping("/login")
    @ResponseBody
    public R login(@RequestParam("user") String username, @RequestParam("password")String password) {

        // 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟 shiro 的拦截地址内．不然后会报空指针
        Subject sub = SecurityUtils.getSubject();
        // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
        // 认证执行者交由 com.battcn.config.AuthRealm 中 doGetAuthenticationInfo 处理
        // 当以上认证成功后会向下执行,认证失败会抛出异常
        //UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.MD5(password));
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            sub.login(token);
        } catch (UnknownAccountException e) {
            logger.error("对用户[{}]进行登录验证,验证未通过,用户不存在", username);
            token.clear();

        } catch (LockedAccountException lae) {
            logger.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", username);
            token.clear();

        } catch (ExcessiveAttemptsException e) {
            logger.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", username);
            token.clear();

        } catch (AuthenticationException e) {
            logger.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", username, e);
            token.clear();

        }

        // 从session中获取 user 对象
        Session session = SecurityUtils.getSubject().getSession();
        UUser userN = (UUser) session.getAttribute("USER_SESSION");

        return  R.ok().message("登陆成功");
    }

   // @RequiresPermissions(value = {"msg:list"})
    @GetMapping("/logina1")
    @ResponseBody
    public R a() throws Throwable {

        try {
            List<String> list=new ArrayList<>();
            list.get(10);
        }catch (Exception e){
            throw new GuliException(2222,"什么什么错误",e);
        }
        return R.ok().message("aa");
    }

}
