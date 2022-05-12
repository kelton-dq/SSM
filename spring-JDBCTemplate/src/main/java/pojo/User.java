/**
 * Copyright (C), 2020-2022, XDU
 * FileName: User
 * Author: Dingq
 * Date: 2022/5/11 16:57
 * Description:
 */
package pojo;

public class User {

    private String id;
    private String uname;
    private String email;
    private String role;

    public String getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}