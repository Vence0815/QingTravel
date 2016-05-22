package com.vence.qingtravel.demon;

/**
 * Created by xys on 2016/5/18.
 *
 * @author xyz
 * @version $Rev$
 * @time 2016/5/18 15:09
 * @updateAuthor $Author$
 * @updateDate $Date$
 */
public class UserInfor {
    private String userName;
    private String passWord;
    private String phoneNum;
    private String imageUrl;
    private int rememberPwd;
    private int autoLogin;
    private int isFirstLogin;

    public UserInfor() {
    }

    public UserInfor(String userName, String passWord, String phoneNum,String imageUrl, int rememberPwd, int autoLogin,int isFirstLogin) {
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
        this.rememberPwd = rememberPwd;
        this.autoLogin = autoLogin;
        this.imageUrl = imageUrl;
        this.isFirstLogin = isFirstLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getRememberPwd() {
        return rememberPwd;
    }

    public void setRememberPwd(int rememberPwd) {
        this.rememberPwd = rememberPwd;
    }

    public int getAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(int autoLogin) {
        this.autoLogin = autoLogin;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(int isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    @Override
    public String toString() {
        return "UserInfor{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", rememberPwd=" + rememberPwd +
                ", autoLogin=" + autoLogin +
                ", isFirstLogin=" + isFirstLogin +
                '}';
    }
}
