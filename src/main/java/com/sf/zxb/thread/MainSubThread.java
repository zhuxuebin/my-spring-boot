package com.sf.zxb.thread;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/6/12
 */
public class MainSubThread {

    public static void main(String[] args) {

        System.out.println("main thread start");

        SubThread subThread = new SubThread();
        subThread.start();

        try{
            subThread.join();
        }catch (Exception e){

        }

        System.out.println("main thread stop");
        while (true){

        }
    }

}

class SubThread extends Thread{
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("sub thread start working.");

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("sub thread stop working, time="+(System.currentTimeMillis()-start)/1000);
    }
}
