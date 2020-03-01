package com.king.commonlib.test;


import android.annotation.SuppressLint;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/***
 *项目名称：ARouteT
 *类描述:rxjava学习
 *创建人：Android
 *创建时间：2019/7/23 14:02
 *修改人：Android
 */

/**
 * rxjava 观察者模式 响应式拉取
 * 相关博客
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
            System.out.println("accept---" + o);
        });
        /**rvjava操作符
         * 5.1map变换操作符
         */
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).map(integer -> "This is result " + integer).subscribe(s -> {
            System.out.println("accept---" + s);
        });
        /**
         *@describe 5.2flatMap操作符
         * FlatMap将一个发送事件的上游Observable变换为多个发送事件的Observables，
         * 然后将它们发射的事件合并后放进一个单独的Observable里
         * 不保证顺序
         */
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).flatMap((Function<Integer, ObservableSource<String>>) integer -> {
            final List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
        }).subscribe(s -> {
            System.out.println("accept---" + s);
        });
        /**
         *@describe 5.3concatMap操作符
         * concatMap将一个发送事件的上游Observable变换为多个发送事件的Observables，
         * 然后将它们发射的事件合并后放进一个单独的Observable里
         * flatMap操作符的作用就是把一个Observable转换为另一个Observable
         * 比如先登录后注册
         * 保证顺序
         */
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).concatMap((Function<Integer, ObservableSource<String>>) integer -> {
            final List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
        }).subscribe(s -> {
            System.out.println("accept---" + s);
        });
        /**
         *@describe 5.4concatMap操作符
         * concatMap将一个发送事件的上游Observable变换为多个发送事件的Observables，
         * 然后将它们发射的事件合并后放进一个单独的Observable里
         * 保证顺序
         * 接收和失败
         * 可以用于
         */
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).concatMap((Function<Integer, ObservableSource<String>>) integer -> {
            final List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
        }).subscribe(s -> {
            System.out.println("accept---" + s);
        }, throwable -> {
            System.out.println("throwable---" + throwable.getMessage());
        });
        /**
         *@describe 5.5zip操作符
         * Zip通过一个函数将多个Observable发送的事件结合到一起，
         * 然后发送这些组合到一起的事件. 它按照严格的顺序应用这个函数。
         * 它只发射与发射数据项最少的那个Observable一样多的数据
         * 比如页面数据需要几个接口返回数据
         * 可以通过zip来打包请求 ，返回所有数据
         */
        Observable observable1 = Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onComplete();
        }).subscribeOn(Schedulers.io());
        Observable observable2 = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onNext("C");
            emitter.onComplete();
        }).subscribeOn(Schedulers.io());
        Observable.zip(observable1, observable2, (BiFunction<Integer, String, String>) (integer, s) -> integer+s)
        .subscribeOn(AndroidSchedulers.mainThread())
        .subscribe(o -> {
            System.out.println("accept---" + o);
        }, throwable -> {

        });

        /**6.0
         * 减缓内存增长的速度，内存爆炸的情况只有在异步的时候才会出现这种情况
         * 增加过滤器filter操作符
         * .filter(new Predicate<Integer>() {
                  @Override
                  public boolean test(Integer integer) throws Exception {
                     return integer % 10 == 0;
                 }
             })
         * sample操作符, 这个操作符每隔指定的时间就从上游中取出一个事件发送给下游
         * .sample(2, TimeUnit.SECONDS)  //sample取样
         */
        /**7.0
         *背压
         *上游变成了Flowable, 下游变成了Subscriber, 但是水管之间的连接还是通过subscribe()
         */
        //flowable.subscribe(subscriber);
        /**
         *BackpressureStrategy.BUFFER 大水缸
         *BackpressureStrategy.ERROR  128的水缸
         *BackpressureStrategy.DROP   直接把消费不了的事件丢弃
         *BackpressureStrategy.LATEST 就是只保留最新的事件
         */
        //链式调用
        Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
            //这种方式会在出现上下游流速不均衡的时候直接抛出一个异常,
            //这个异常就是著名的MissingBackpressureException
            //↓↓↓
        },BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                //一定要设置 request当做是一种能力, 当成Subscriber处理事件的能力
                //在Flowable里默认有一个大小为128的水缸, 当上下游工作在不同的线程中时,
                //上游就会先把事件发送到这个水缸中, 因此, 下游虽然没有调用request,
                //但是上游在水缸中保存着这些事件, 只有当下游调用request时, 才从水缸里取出事件发给下游.
                s.request(Long.MAX_VALUE);
            }
            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext---" + integer);
            }
            @Override
            public void onError(Throwable t) {
                System.out.println("onError---" + t.getMessage());
            }
            @Override
            public void onComplete() {
                System.out.println("onComplete---");
            }
        });
        Flowable.interval(1, TimeUnit.MICROSECONDS)
                .onBackpressureDrop()  //加上背压策略
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(128);
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Maybe.just(1).subscribe(integer -> {

        }, throwable -> {

        });
        //https://www.jianshu.com/p/1922bd75ee73
        //和Observable功能几乎一模一样，★★背压策略，一定要在线程变换之前去调用★★
        //区别在于：
        //1.定义的类功能不一样
        //2.Flowable可以通过Subscription对象，调用request(n)，响应式拉取数据，来支持背压特性
        //3.★★背压策略，一定要在线程变换之前去调用★★
        //io.reactivex.Flowable
        //基本都使用他
        //io.reactivex.Observable
        //这个流只会收到一个数据或者一个error，也就是要不然执行onSuccess要不然就执行onError
        //io.reactivex.single
        //和Single类似正常流程也是只执行onSuccess，但在出现错误的时候，可以选择是执行onError还是onComplete
        //io.reactivex.Maybe
        //这个流没有数据，只会收到error或者complete
        //io.reactivex.Completable
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
     */
    static Observer<String> reader = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            //处理观察者和被观察者的,如果观察者不想再订阅了,请调用
            //d.dispose();
            System.out.println("onSubscribe---" + d.isDisposed());
            //CompositeDisposable类
            //1、可以快速解除所有添加的Disposable类.
            //2、每当我们得到一个Disposable时就调用CompositeDisposable.add()将它添加到容器中,
            //在退出的时候, 调用CompositeDisposable.clear() 即可快速解除.
        }

        //跟emitterd对应
        @Override
        public void onNext(String s) {
            System.out.println("onNext---" + s);
        }

        //跟emitterd对应
        @Override
        public void onError(Throwable e) {
            System.out.println("onError---" + e.getMessage());
        }

        //跟emitterd对应
        @Override
        public void onComplete() {
            System.out.println("onComplete---");
        }
    };
    static Flowable<Integer>flowable = Flowable.create(emitter -> {
        emitter.onNext(1);
        emitter.onNext(2);
        emitter.onNext(3);
        emitter.onComplete();
    },BackpressureStrategy.ERROR);
    static Subscriber<Integer> subscriber =new Subscriber<Integer>() {
        @Override
        public void onSubscribe(Subscription s) {
            s.request(Long.MAX_VALUE);  //注意这句代码
        }
        @Override
        public void onNext(Integer integer) {
            System.out.println("onNext---" + integer);
        }
        @Override
        public void onError(Throwable t) {
            System.out.println("onError---" + t.getMessage());
        }
        @Override
        public void onComplete() {
            System.out.println("onComplete---");
        }
    };
}
