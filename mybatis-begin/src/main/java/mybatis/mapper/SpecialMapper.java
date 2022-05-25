package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialMapper {

    //模糊查询
    List<User> getUserByLike(@Param("username") String username);

    //批量删除
    int deleteMore(@Param("ids") String ids);

    //动态表名
    List<User> getUserByTable(@Param("tableName") String tableName);

    //获取递增主键
    void insertUser(User user);
}
