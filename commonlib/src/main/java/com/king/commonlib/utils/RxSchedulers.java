package com.king.commonlib.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @CompanyName: xxxx科技
 * @ProjectName: ARouteT
 * @Package: com.king.commonlib.utils
 * @ClassName: RxSchedulers
 * @Description: 通用的Rx线程转换类
 * 参考:http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0819/3327.html
 * @Author: 庄学南
 * @CreateDate: 2019/7/31 0031 20:44
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/31 0031 20:44
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RxSchedulers {
    static final ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return (upstream)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }
}
