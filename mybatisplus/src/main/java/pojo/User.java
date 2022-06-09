/**
 * Copyright (C), 2020-2022, XDU
 * FileName: User
 * Author: Dingq
 * Date: 2022/6/2 15:32
 * Description:
 */
package pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
//@ToString
@Data
@TableName("user")
public class User {

    @TableId
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
}