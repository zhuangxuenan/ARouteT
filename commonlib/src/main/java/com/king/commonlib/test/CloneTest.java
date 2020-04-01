package com.king.commonlib.test;

import androidx.annotation.NonNull;

/**
 * @CompanyName: xxxx科技
 * @ProjectName: ARouteT
 * @Package: com.king.commonlib.test
 * @ClassName: CloneTest
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/26 0026 19:41
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/26 0026 19:41
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class CloneTest implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CloneTest clone(){
        try {
            return (CloneTest)super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
