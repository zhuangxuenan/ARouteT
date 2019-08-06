package com.king.mine;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.mine$
 * @ClassName: Test$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2019/8/6$ 16:27$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/6$ 16:27$
 * @UpdateRemark: 更新说明：
 */
public class Test extends AppCompatActivity {
    TextView mine_tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        mine_tv = findViewById(R.id.mine_tv);

    }
}
