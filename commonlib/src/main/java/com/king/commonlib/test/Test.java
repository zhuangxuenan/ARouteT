package com.king.commonlib.test;


import android.annotation.SuppressLint;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/***
 *项目名称：ARouteT
 *类描述:rxjava学习
 *创建人：Android
 *创建时间：2019/7/23 14:02
 *修改人：Android
 */
/**相关博客
 * https://www.jianshu.com/p/cd3557b1a474
 * 该系列有十篇
 * https://www.jianshu.com/p/464fa025229e
 * ↓↓↓↓
 * https://www.jianshu.com/u/c50b715ccaeb
 **/
public class Test {
    @SuppressLint("CheckResult")
    public static void main(String args[]) {
        /**1.0
         *观察者被观察者建立订阅关系
         * 只有观察者和被观察者建立了订阅关系才会如此
         */
        //mObservable.subscribe(reader);
        /**2.0
         *rxjava调度器Scheduler以及rxjava的链式调用
         * 2.1多次指定上游的线程（执行的线程subscribeOn）只有第一次指定的有效,
         * 也就是说多次调用subscribeOn() 只有第一次的有效, 其余的会被忽略.
         * 2.2多次指定下游的线程是可以的,
         * 也就是说每调用一次observeOn() , 下游的线程就会切换一次.
         * 关于线程
         * 在RxJava中, 已经内置了很多线程选项供我们选择, 例如有：
         * Schedulers.io()                 代表io操作的线程, 通常用于网络,读写文件等io密集型的操作
         * Schedulers.computation()        代表CPU计算密集型的操作, 例如需要大量计算的操作
         * Schedulers.newThread()          代表一个常规的新线程
         * AndroidSchedulers.mainThread()  代表Android的主线程
         */
        /*Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("-----连载1");
            emitter.onNext("-----连载2");
            emitter.onNext("-----连载3");
            emitter.onComplete();
        }).observeOn(AndroidSchedulers.mainThread())//回调在主线程
          .subscribeOn(Schedulers.io())//执行在io线程
          .subscribe(new Observer<String>() {
              @Override
              public void onSubscribe(Disposable d) {
                  //处理观察者和被观察者的,如果观察者不想再订阅了,请调用
                  //d.dispose();
                  System.out.println("-----onSubscribe---"+d.isDisposed());
              }
              //跟emitterd对应
              @Override
              public void onNext(String s) {
                  System.out.println("-----onNext---"+s);
              }
              //跟emitterd对应
              @Override
              public void onError(Throwable e) {
                  System.out.println("-----onError---"+e.getMessage());
              }
              //跟emitterd对应
              @Override
              public void onComplete() {
                  System.out.println("------onComplete---");
              }
        });*/
        /***
         * 3.0
         *被观察者可以有一个空订阅
         */
        //mObservable.subscribe();
        /***
         * 4.0
         *观察者可以只订阅onnext方法
         */
        mObservable.subscribe((Consumer<String>) o -> {
            System.out.println("accept---"+o);
        });
        /**rvjava操作符
         * 5.1map变换操作符
         */
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).map(integer -> "This is result " + integer).subscribe(s -> {
            System.out.println("accept---"+s);
        });

    }



    /**
     * 被观察者
     * 1.0泛型为被操作的类型
     * 1.1emitter称为发射器
     * 1.2有三种发射的方法，分别是
     * void onNext(T value)、void onError(Throwable error)、onComplete()，
     * onNext方法可以无限调用，Observer（观察者）所有的都能接收到，
     * onError和onComplete是互斥的，Observer（观察者）只能接收到一个，
     * OnComplete可以重复调用，但是Observer（观察者）只会接收一次，
     * 而onError不可以重复调用，第二次调用就会报异常。
     */
    static Observable mObservable = Observable.create((ObservableOnSubscribe<String>) emitter -> {
        emitter.onNext("连载1");
        emitter.onNext("连载2");
        emitter.onNext("连载3");
        emitter.onComplete();
    });
    /**
     * 观察者
     *
     */
    static Observer<String> reader = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            //处理观察者和被观察者的,如果观察者不想再订阅了,请调用
            //d.dispose();
            System.out.println("onSubscribe---"+d.isDisposed());
        }
        //跟emitterd对应
        @Override
        public void onNext(String s) {
            System.out.println("onNext---"+s);
        }
        //跟emitterd对应
        @Override
        public void onError(Throwable e) {
            System.out.println("onError---"+e.getMessage());
        }
        //跟emitterd对应
        @Override
        public void onComplete() {
            System.out.println("onComplete---");
        }
    };
}
