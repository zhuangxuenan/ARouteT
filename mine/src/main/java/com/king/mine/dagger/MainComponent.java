package com.king.mine.dagger;

import com.king.mine.MineTActivity;

import dagger.Component;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.mine.dagger$
 * @ClassName: MainComponent$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2019/8/5$ 14:11$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/5$ 14:11$
 * @UpdateRemark: 更新说明：
 */
//第一步 添加@Component
//第二步 添加module
@Component(modules = {MainModule.class})
@MainScope//如果moudle实例化对象是单例的，那么相应的Component也要是单例的
public interface MainComponent {
    //第三步  写一个方法 绑定Activity /Fragment
    void inject(MineTActivity activity);
}
