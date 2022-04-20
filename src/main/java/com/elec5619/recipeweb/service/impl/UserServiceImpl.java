package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.mapper.UserMapper;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;


/** userService Implementation */
//@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            throw new InvalidValueException("null value of username or password");
        }

        User result = userMapper.findByUsername(user.getUsername());

        if (result != null){
            throw new UsernameDuplicationException("User existed");
        }

        // user password encryption: md5
        String rawPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        user.setPassword(getMD5Password(rawPassword, salt));

        // complete user data
        Date date = new Date();
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("Failure during insert");
        }
    }

    @Override
    public User login(String username, String password) {

        if (username == null || password == null) {
            throw new InvalidValueException("null value of username or password");
        }

        User result = userMapper.findByUsername(username);

        if (result == null) {
            throw new UserNotFoundException("User info not Exist");
        }

        String salt = result.getSalt();
        String tempPassword = getMD5Password(password, salt);
        if (!tempPassword.equals(result.getPassword())) {
            throw new PasswordNotMatchException("Wrong password");
        }

        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("User info is Deleted");
        }

        return result;
    }

    @Override
    public Integer updatePassword(String userId, String newPassword) {
        User result = userMapper.selectById(userId);
        if (result == null) {
            throw new UserNotFoundException("Update password on none User");
        }
        result.setPassword(getMD5Password(newPassword, result.getSalt()));
        Integer rows = userMapper.updateById(result);
        return rows;
    }

    private String getMD5Password(String password, String salt) {
        String result = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        return result;
    }
}
