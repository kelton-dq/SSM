package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParameterMapper {
    List<User> getAllUser();

    User getUserByUsername(String username);

    User checkLogin(String username,String password);

    int insertUser(User user);

    User CheckLoginByParam(@Param("username") String username, @Param("password") String password);
}
