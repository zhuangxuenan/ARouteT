package com.king.commonlib.test;

/**
 * @CompanyName: xxxx科技
 * @ProjectName: ARouteT
 * @Package: com.king.commonlib.test
 * @ClassName: Du
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/24 0024 18:46
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/24 0024 18:46
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class Du {
    public static void main(String[] args) {
        recursion_display(10);
    }
    public static void recursion_display(int n) {
        int temp=n;//保证前后打印的值一样
        System.out.println("递进:" + temp);
        if (n > 0) {
            recursion_display(--n);
        }
        System.out.println("回归:" + temp);
    }
}
