package com.baway.loginactivity.bean;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/25 16:52
 * @Description：描述信息
 */
public class User {
    private String headPic;
    private String nickName;
    private String phone;
    private String sessionId;
    private int sex;
    private int userId;

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
