package com.king.commonlib.test;

import android.content.SyncStatusObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @CompanyName: xxxx科技
 * @ProjectName: ARouteT
 * @Package: com.king.commonlib.test
 * @ClassName: OutPrint
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/29 0029 14:18
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/29 0029 14:18
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OutPrint {
    public static List<String> getAserList(String opt) {
        List<String> list = new ArrayList<>();
        char[] a = opt.toCharArray();
        for (int i = 0; i < a.length; i++) {
            int r = (a[i]+1) % 3 + 1;
            //int r = i % 3 + 1;
            list.add(String.valueOf(r) + a[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        String opt = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        List<String> list= getAserList(opt);
        for(String s:list){
            System.out.println(s);
        }
    }
}
