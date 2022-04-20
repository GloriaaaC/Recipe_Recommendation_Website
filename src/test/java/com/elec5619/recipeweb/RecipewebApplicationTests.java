package com.elec5619.recipeweb;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.TimeZone;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecipewebApplicationTests {

    @Autowired //自动装配
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }


    /**
     * 数据库连接池
     * 1.DBCP
     * 2.C3P0
     * 3.Hikari (当前最快连接池)
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println(TimeZone.getDefault()); //输出当前默认时区
        final TimeZone zone = TimeZone.getTimeZone("GMT+8"); //获取中国时区
        TimeZone.setDefault(zone); //设置时区
        System.out.println(TimeZone.getDefault()); //输出验证
    }
}
