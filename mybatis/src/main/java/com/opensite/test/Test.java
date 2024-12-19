package com.opensite.test;

import com.opensite.dao.UserDao;
import com.opensite.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        // 记得要把 resource 添加到资源
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // select * from ...
        //for (User user : userDao.findAll()) {
        //    System.out.println(user);
        //}

        // select * from where id = ...
        //User user1 = userDao.findById(1);

        // delete * from ... where id = ...
        // todo: 不添加事务提交，不会执行 delete 操作
        //userDao.deleteById(1);

        User user = new User(10, "Helen", "pwd12312", "女", "苏州");
        userDao.add(user);
        // todo: 不添加事务提交，不会执行 insert 操作
        sqlSession.commit();


        //System.out.println(user1);

        // 使用完成，释放资源
        sqlSession.close();
    }


}