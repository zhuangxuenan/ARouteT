package com.king.commonlib.test;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.king.commonlib.utils.RxSchedulers;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @CompanyName: xxxx科技
 * @ProjectName: ARouteT
 * @Package: com.king.commonlib.test
 * @ClassName: RxTestActivity
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/25 0025 17:45
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/25 0025 17:45
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RxTestActivity extends RxAppCompatActivity {
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("-----连载1");
            emitter.onNext("-----连载2");
            emitter.onNext("-----连载3");
            emitter.onComplete();
        }).compose(RxSchedulers.applySchedulers())
           .compose(bindToLifecycle())
           .subscribe(s -> {

           });


        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("-----连载1");
            emitter.onNext("-----连载2");
            emitter.onNext("-----连载3");
            emitter.onComplete();
        }).compose(RxSchedulers.applySchedulers())
                .compose(RxLifecycle.bind(lifecycle()))
                .subscribe(s -> {

                });


        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("-----连载1");
            emitter.onNext("-----连载2");
            emitter.onNext("-----连载3");
            emitter.onComplete();
        }).compose(RxSchedulers.applySchedulers())
                .compose(RxLifecycleAndroid.bindActivity(lifecycle()))
                .subscribe(s -> {

                });
    }
}
