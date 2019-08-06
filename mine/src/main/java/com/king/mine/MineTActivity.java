package com.king.mine;


import android.os.Bundle;
import android.widget.TextView;

import com.king.mine.dagger.A;
import com.king.mine.dagger.B;
import com.king.mine.dagger.DaggerMainComponent;
import com.king.mine.dagger.ProvideNewBody;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/***
 *项目名称：ARouteT
 *类描述:
 *创建人：Android
 *创建时间：2019/8/2 16:32
 *修改人：Android
 */
public class MineTActivity extends AppCompatActivity {
    TextView mine_tv;
    //使用Inject 注解，获取到A 对象的实例
    @Inject
    @ProvideNewBody//使用指定的方法来创建依赖实例因为目标类有多个构造方法
    A a;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        mine_tv = findViewById(R.id.mine_tv);
        //添加依赖关系的两种方式
        //DaggerMainComponent.builder().build().inject(this);
        DaggerMainComponent.create().inject(this);
        B b = a.getB();
        a.setS2("我是来自A的变量");
        b.setS1("我是来自B的变量");
        mine_tv.setText(a.getS2()+"\n"+b.getS1());
    }
}
