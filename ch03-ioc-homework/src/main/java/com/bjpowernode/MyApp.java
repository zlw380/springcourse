package com.bjpowernode;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        //从spring容器中获取 UserService类型的对象 , dao, service都是spring管理的
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService) ctx.getBean("userService");
        SysUser sysUser = (SysUser) ctx.getBean("sysUser");
        UserDao userDao = (UserDao) ctx.getBean("mysqlDao");
        UserDao oracleDao = (UserDao) ctx.getBean("oracleDao");
        System.out.println(userDao);
        System.out.println(oracleDao);

        service.addUser(sysUser);
        System.out.println(service.getDao());
    }
}
