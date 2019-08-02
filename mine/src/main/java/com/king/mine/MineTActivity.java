package com.king.mine;

import android.os.Bundle;
import android.widget.TextView;

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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        mine_tv = findViewById(R.id.mine_tv);

    }
}
