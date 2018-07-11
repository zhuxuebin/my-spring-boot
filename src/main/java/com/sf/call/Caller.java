package com.sf.call;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/6/21
 */
public class Caller {
    private  MyCallerInterface myCallerInterface;

    public Caller(){

    }

    public void setMyCallerInterface(MyCallerInterface myCallerInterface){
        this.myCallerInterface = myCallerInterface;
    }

    public void call(String name){
        myCallerInterface.printName(name);
    }

    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.setMyCallerInterface(new MyCallerInterface() {
            @Override
            public void printName(String name) {
                System.out.println("name:"+name);
            }
        });
        caller.call("zxb");
    }
}
