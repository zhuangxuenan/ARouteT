package com.king.mine.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.mine.dagger$
 * @ClassName: ProvideBody$
 * @Description: 用于注解有多个构造方法的类
 * @Author: 庄学南
 * @CreateDate: 2019/8/6$ 14:17$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/6$ 14:17$
 * @UpdateRemark: 更新说明：
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ProvideBody {

}
