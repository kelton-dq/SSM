package mybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author dingq
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-06-09 15:25:41
* @Entity mybatisx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAllByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);
}




