package com.eric.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: TestAutomic
 * @Description: 测试原子性操作
 * @Author: Eric
 * @Date: 2019/3/6 0006
 * @Email: xiao_cui_vip@163.com
 */
public class TestAutomic {
    public static void main(String[] args) {
        AutomaticDemo at = new AutomaticDemo();
        for(int i=0;i<10;i++){
            new Thread(at).start();
        }

    }


}

class AutomaticDemo implements Runnable {
    private AtomicInteger sn = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getSn());
    }

    public int getSn() {
        return sn.getAndIncrement();
    }
}
