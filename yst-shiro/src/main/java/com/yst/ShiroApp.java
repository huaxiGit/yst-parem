package com.yst;

/**
 * @author zhanghuaxi
 * @title: ShiroApp
 * @projectName yst-parem
 * @description: TODO         // 学习网站  https://blog.csdn.net/leilei1366615/article/details/99571695?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
 * @date 2021/1/26下午8:31
 */
public class ShiroApp {
}
/**
 2.主要功能

 shiro主要有三大功能模块：

 1. Subject：主体，一般指用户。

 2. SecurityManager：安全管理器，管理所有Subject，可以配合内部安全组件。(类似于SpringMVC中的DispatcherServlet)

 3. Realms：用于进行权限信息的验证，一般需要自己实现。

 3.细分功能

 1. Authentication：身份认证/登录(账号密码验证)。

 2. Authorization：授权，即角色或者权限验证。

 3. Session Manager：会话管理，用户登录后的session相关管理。

 4. Cryptography：加密，密码加密等。

 5. Web Support：Web支持，集成Web环境。

 6. Caching：缓存，用户信息、角色、权限等缓存到如redis等缓存中。

 7. Concurrency：多线程并发验证，在一个线程中开启另一个线程，可以把权限自动传播过去。

 8. Testing：测试支持；

 9. Run As：允许一个用户假装为另一个用户（如果他们允许）的身份进行访问。

 10. Remember Me：记住我，登录后，下次再来的话不用登录了。


 */