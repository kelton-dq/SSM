package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mapper.UserMapper;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

/**
 * @fileName: UserServiceImpl
 * @description:
 * @author: Kelton
 * @create: 2022-06-08 15:19
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
