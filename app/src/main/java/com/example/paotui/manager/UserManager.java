package com.example.paotui.manager;

import com.example.paotui.bmob.MyUser;

public class UserManager {
    /**
     * 单例
     */
    private static class UserManagerHolder{
        private static final UserManager INSTANCE = new UserManager();
    }

    public static final UserManager getInstance(){
        return UserManagerHolder.INSTANCE;
    }

    private UserManager(){

    }

    private MyUser myUser;

    public void saveUser(MyUser user){
        this.myUser = user;
    }

    public MyUser getUser(){
        return myUser;
    }

    public void removeUser(){
        myUser = null;
    }
}
