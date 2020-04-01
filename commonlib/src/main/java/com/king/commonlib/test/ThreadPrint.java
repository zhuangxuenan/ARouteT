package com.king.commonlib.test;

/**
 * @CompanyName: xxxx科技
 * @ProjectName: ARouteT
 * @Package: com.king.commonlib.test
 * @ClassName: ThreadPrint
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/29 0029 14:42
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/29 0029 14:42
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ThreadPrint {
    private static char c = 'A';// 必要的时候声明为volatile类型的
    private static int i = 0;
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        int threaId = Integer.parseInt(Thread.currentThread().getName());
                        System.out.println("当前线程id:"+threaId);
                        while (i<26){
                            if(i%3==threaId-1){
                                System.out.println("线程id：" + threaId +(c++));
                                i++;
                                if(i==26){
                                    System.out.println("打印结束-------");
                                }
                                notifyAll();
                            }else{
                                wait();
                            }
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r,"1").start();
        new Thread(r,"2").start();
        new Thread(r,"3").start();
    }
}
