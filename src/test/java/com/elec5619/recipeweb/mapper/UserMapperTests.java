package com.elec5619.recipeweb.mapper;

import com.elec5619.recipeweb.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("Testing2");
        user.setPassword("123456");
        int rows = userMapper.insert(user);
        System.out.println(rows);
    }


    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("Testing");
        System.out.println(user);
    }

}
