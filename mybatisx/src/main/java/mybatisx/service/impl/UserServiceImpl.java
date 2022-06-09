package mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatisx.pojo.User;
import mybatisx.service.UserService;
import mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author dingq
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-06-09 15:25:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




