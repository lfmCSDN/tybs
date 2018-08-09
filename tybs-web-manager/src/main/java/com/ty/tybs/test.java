package com.ty.tybs;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * create by Lfm
// * on 2018-08-06 22:06
 */
@Component
public class test {

    @Autowired

    private SqlSessionFactory sqlSessionFactory;


@Scheduled(cron = "0 0 2 1/1 * ? *")
    public  void demo(){
        SqlSession sqlSession =null;
        Connection connection=null;
        Statement statement=null;
        try {
              sqlSession = sqlSessionFactory.openSession();
              connection = sqlSession.getConnection();
              statement= connection.createStatement();
              statement.execute("");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (sqlSession!=null){
                sqlSession.close();

            }


        }

    }



}
