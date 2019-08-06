package com.king.mine.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.mine.dagger$
 * @ClassName: MainScope$
 * @Description: dagger单例实现
 * @Author: 庄学南
 * @CreateDate: 2019/8/6$ 14:35$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/6$ 14:35$
 * @UpdateRemark: 更新说明：
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MainScope {
}
