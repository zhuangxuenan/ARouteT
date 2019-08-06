package com.king.mine.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.mine.dagger$
 * @ClassName: MainModule$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2019/8/5$ 14:07$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/5$ 14:07$
 * @UpdateRemark: 更新说明：
 */

/**
 * @Module (includes = { BModule.class })// includes 引入)
 * public class AModule {
 * @Provides A providerA() {
 * return new A();
 * }
 * }
 * 这样的话，Dagger会现在A moudule 中寻找对象，如果没找到，会去找module B 中是否有被Inject注解的对象，如果还是没有，那么GG，抛出异常
 * 第一步，用 @Module 声明一个类，代表这个类是拥有对外提供实例的功能。
 * 第二步，用 @Provides 修饰一个方法，该方法返回具体的实例对象。
 * 第三步，修改用 @Component 修饰的 interface，指定其需要的 Module 模块。
 * @Inject，注意下，这个注解类的全名称是javax.inject.Inject， 是Java扩展包定义的注解。@Inject 可以修饰一个引用，代表此处可通过依赖注入传入一个实例对象，
 * 需要注意的是引用的访问修饰符不能是 private 和 protected，默认包访问权限即可；
 * 还可以修饰一个类的构造函数，作为一个标记，代表框架可能会根据该标调用此构造函数生成实例对象。
 * @Module、@Provides，主要是为了解决第三方类库问题而生的，Module 中可以定义多个创建实例的方法，这些方法用 @Provides 标注。
 * @Component，是一个中间人的角色（也可理解为干活的秘书）， 也是一个注入器，负责将生成的实例对象注入到依赖的需求者中，同时管理多个 Module。
 * https://upload-images.jianshu.io/upload_images/7282185-7daf69b170473bf4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000
 */
//第一步 添加@Module 注解
@Module
public class MainModule {
    @Provides
    B providerB() {
        return new B();
    }

    //第二步 使用Provider 注解 实例化对象
    @ProvideNewBody//标识两个不同的构造方法。另外需要在目标类依赖实例的地方标识需要使用哪个构造方法，这样就能使用指定的方法来创建依赖实例了
    @Provides
    @MainScope//单例只能在一个实例化方法上使用
    A providerA(B b) {
        return new A(b);
    }

    /*@ProvideBody//标识两个不同的构造方法。另外需要在目标类依赖实例的地方标识需要使用哪个构造方法，这样就能使用指定的方法来创建依赖实例了
    @Provides
    @MainScope
    A providerA() {
        return new A();
    }*/
}
