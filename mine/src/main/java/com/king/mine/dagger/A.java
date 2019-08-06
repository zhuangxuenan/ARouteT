package com.king.mine.dagger;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.mine.dagger$
 * @ClassName: A$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2019/8/5$ 11:47$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/5$ 11:47$
 * @UpdateRemark: 更新说明：
 */
public class A {
    private B b;
    private String s2;

    public A() {
    }

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }
}
