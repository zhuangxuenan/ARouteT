package com.king.mine.dagger;

import com.king.mine.Test;

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
@Component(dependencies = MainComponent.class)
@AnimalScope//这个是为了演示两个Component对象共享依赖实例，并且共用一个对象 非必选
public interface AnimalComponent {
    //第三步  写一个方法 绑定Activity /Fragment
    void inject(Test activity);
}
