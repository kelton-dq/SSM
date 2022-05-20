/**
 * Copyright (C), 2020-2022, XDU
 * FileName: User
 * Author: Dingq
 * Date: 2022/5/20 12:02
 * Description:
 */
package mvc.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String sex;

    private Integer age;

    public User() {
    }

    public User(Integer id, String username, String password, String sex, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}