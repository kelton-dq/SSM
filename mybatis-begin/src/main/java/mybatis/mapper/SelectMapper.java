package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface SelectMapper {

    User getUserById(@Param("id") int id);

    Map<String, Object> getUserToMap(@Param("id") int id);

    @MapKey("id")
    Map<String, Object> getAllUserToMap();


}
