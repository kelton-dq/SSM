package mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pojo.Product;

/**
 * @fileName: ProductMapper
 * @description:
 * @author: Kelton
 * @create: 2022-06-09 11:05
 **/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
