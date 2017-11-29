package com.dhq.databinding.entity;

import android.databinding.BaseObservable;
import android.view.View;

import java.io.Serializable;

/**
 * DESC  用户信息
 * Created by douhaoqiang on 2017/11/29.
 */

public class UserEntity extends BaseObservable {

    private String name;
    private String birthday;
    private String gender;
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        notifyChange();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyChange();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyChange();
    }


}
