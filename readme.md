# Databinding绑定数据使用

## 1、gradle 配置
    android {
        ...
        dataBinding {
            enabled = true
        }

    }
## 2、数据引入布局文件
    <layout xmlns:android="http://schemas.android.com/apk/res/android">
        <data>
            <variable
                name="user"
                type="com.dhq.databinding.entity.UserEntity" />

            <variable
                name="handle"
                type="com.dhq.databinding.MainClickHandle" />
        </data>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:orientation="vertical">


            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="获取用户信息"
                android:onClick="@{handle.onClickObtainUserInfo}"/>
            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="修改用户姓名"
                android:onClick="@{handle.onClickChangeUserName}"/>

            <TextView
                android:id="@+id/textView1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@{user.name}" />
        </LinearLayout>
    </layout>

## 3、数据界面元素绑定

    activity中绑定界面（ActivityMainBinding名称并不一定统一）
    ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    //绑定数据
    UserEntity user = new UserEntity();
    user.setName("张三");
    user.setBirthday("2018-05-21");
    user.setGender("男");
    user.setAvatar("http://www.baidu.com/user/avatar.png");
    viewDataBinding.setUser(user);
## 4、数据更新

    实体类集成BaseObservable，在set方法中档数据改变后调用notifyChange()更新界面

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

    }
    //当数据改变后只需要调用set方法即可改变界面元素
    user.setName("李四");

