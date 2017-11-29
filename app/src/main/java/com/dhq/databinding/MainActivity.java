package com.dhq.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dhq.databinding.databinding.ActivityMainBinding;
import com.dhq.databinding.entity.UserEntity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding viewDataBinding;
    UserEntity user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //绑定点击事件
        viewDataBinding.setHandle(new MainClickHandle() {
            @Override
            public void onClickObtainUserInfo(View view) {
                getUserInfo();
            }

            @Override
            public void onClickChangeUserName(View view) {
                if(user!=null){
                    user.setName("李四");
                }
            }

        });
    }


    private void getUserInfo() {
        user = new UserEntity();
        user.setName("张三");
        user.setBirthday("2018-05-21");
        user.setGender("男");
        user.setAvatar("http://www.baidu.com/user/avatar.png");
        viewDataBinding.setUser(user);
    }

}
