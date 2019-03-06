package com.eric.volatileTest;

/**
 * @ClassName: TestVolatile
 * @Description: 测试Volatile关键字
 * @Author: Eric
 * @Date: 2019/3/6 0006
 * @Email: xiao_cui_vip@163.com
 */
public class TestVolatile {

    /**
     * volatile关键字：当多个线程操作共享数据时，可以保证内存中的数据可见
     * 相较于synchronized关键字是一种轻量级的同步策略、
     * volatie不具备互斥性，不能保证变量的原子性
     *
     */
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true){
            if(td.isFlag()){
                System.out.println("-------------");
                break;
            }
        }
    }




}

class ThreadDemo implements Runnable {
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("flag=" + isFlag());
    }
}
